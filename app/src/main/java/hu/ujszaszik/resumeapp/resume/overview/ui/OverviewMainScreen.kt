package hu.ujszaszik.resumeapp.resume.overview.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import hu.ujszaszik.resumeapp.compose.view.local.defaultCompositionLocal
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

val LocalActivity = defaultCompositionLocal<Activity>()
val LocalViewModel = defaultCompositionLocal<ResumeViewModel>()

@Composable
fun OverviewLocalProvider(
    viewModel: ResumeViewModel,
    activity: Activity,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalActivity provides activity,
        LocalViewModel provides viewModel
    ) { content.invoke() }
}

@Composable
fun OverviewMainScreen(viewModel: ResumeViewModel, activity: Activity) {
    OverviewLocalProvider(viewModel, activity) {
        val loadingState = viewModel.isLoading.observeAsState()
        loadingState.value?.let { isLoading ->
            if (isLoading) LoadingScreen()
            else OverviewScreen()
        }
    }
}