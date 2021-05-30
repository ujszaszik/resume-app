package hu.ujszaszik.resumeapp.resume.overview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.lottie.LottieAnimationView

@Composable
fun LoadingScreen() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.loading) }
    LoadingAnimation(animationSpec)
}

@Composable
fun LoadingAnimation(animationSpec: LottieAnimationSpec) {
    LottieAnimationView(
        animationSpec = animationSpec,
        margin = R.dimen.loading_animation_margin,
        size = R.dimen.loading_animation_size
    )
}