package hu.ujszaszik.resumeapp.resume.personal.language

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import hu.ujszaszik.resumeapp.extensions.initForValue
import hu.ujszaszik.resumeapp.extensions.setImageDrawableByName

@BindingAdapter("app:languageFlag")
fun ImageView.languageFlag(imageName: String) {
    setImageDrawableByName(imageName)
}

@BindingAdapter("app:languageRating")
fun RatingBar.languageRating(value: Double) {
    initForValue(value)
}