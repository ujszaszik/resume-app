package hu.ujszaszik.resumeapp.resume.personal.personality

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import hu.ujszaszik.resumeapp.extensions.setImageDrawableByName

@BindingAdapter("app:personalityImage")
fun ImageView.personalityImage(imageName: String) {
    setImageDrawableByName(imageName)
}