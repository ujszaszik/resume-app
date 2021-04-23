package hu.ujszaszik.resumeapp.resume.overview

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView

@BindingAdapter("app:isAnimationVisible")
fun LottieAnimationView.isVisible(value: Boolean?) {
    setVisibleState(this, value)
}

@BindingAdapter("app:isTextVisible")
fun TextView.isVisible(value: Boolean?) {
    setVisibleState(this, value)
}

private fun setVisibleState(view: View, value: Boolean?) {
    var visibilityMode = View.INVISIBLE
    value?.let {
        visibilityMode = if (it) View.VISIBLE else View.INVISIBLE
    }
    view.visibility = visibilityMode
}
