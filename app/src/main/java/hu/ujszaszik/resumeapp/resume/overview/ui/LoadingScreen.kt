package hu.ujszaszik.resumeapp.resume.overview.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.ujszaszik.resumeapp.R

private val lottieAnimationViewStyle =
    Modifier
        .size(100.dp)
        .padding(30.dp)

@Composable
fun LoadingScreen() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.loading) }
    LoadingAnimationView(animationSpec)
}

@Composable
fun LoadingAnimationView(animationSpec: LottieAnimationSpec) {
    LottieAnimation(animationSpec, modifier = lottieAnimationViewStyle)
}