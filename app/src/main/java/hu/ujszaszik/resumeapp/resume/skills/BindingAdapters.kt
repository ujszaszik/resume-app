package hu.ujszaszik.resumeapp.resume.skills

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import hu.ujszaszik.resumeapp.extensions.initForValue
import hu.ujszaszik.resumeapp.extensions.setImageDrawableByName


@BindingAdapter("app:skillRating")
fun RatingBar.skillDescription(value: Double) {
    initForValue(value)
}

@BindingAdapter("app:skillImage")
fun ImageView.skillImage(imageName: String) {
    setImageDrawableByName(imageName)
}