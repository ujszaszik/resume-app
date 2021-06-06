package hu.ujszaszik.resumeapp.resume.personal

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.livedata.observeAsState
import hu.ujszaszik.resumeapp.compose.view.local.ContextProvided
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

@InternalComposeApi
@Composable
fun ProfileContent(context: Context, viewModel: ResumeViewModel) {
    ContextProvided(context) {
        val languages = viewModel.languages.observeAsState()
        val remarks = viewModel.personalityData.observeAsState()
        val quotes = viewModel.quotes.observeAsState()
        ProfileScreen(
            languages = languages.value,
            remarks = remarks.value,
            quotes = quotes.value
        )
    }
}