package hu.ujszaszik.resumeapp.compose.view.lottie

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@Composable
fun LottieAnimationView(
    animationSpec: LottieAnimationSpec,
    @DimenRes size: Int = 0,
    @DimenRes margin: Int = 0
) {
    val modifier = Modifier
        .size(safeDimenResource(size))
        .padding(safeDimenResource(margin))
    LottieAnimation(animationSpec, modifier)
}