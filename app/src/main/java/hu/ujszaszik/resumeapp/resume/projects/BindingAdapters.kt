package hu.ujszaszik.resumeapp.resume.projects

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.databinding.BindingAdapter

internal const val DESCRIPTION_TITLE_LENGTH = 11
internal const val ROLES_TITLE_LENGTH = 5
internal const val TECHNOLOGIES_TITLE_LENGTH = 12

@BindingAdapter("app:experienceDescription")
fun TextView.experienceDescription(text: String) {
    this.text = getUnderlinedUntil(text, DESCRIPTION_TITLE_LENGTH)
}

@BindingAdapter("app:experienceRoles")
fun TextView.experienceRoles(text: String) {
    this.text = getUnderlinedUntil(text, ROLES_TITLE_LENGTH)
}

@BindingAdapter("app:experienceTechnologies")
fun TextView.experienceTechnologies(text: String) {
    this.text = getUnderlinedUntil(text, TECHNOLOGIES_TITLE_LENGTH)
}

private fun getUnderlinedUntil(text: String, end: Int): SpannableString {
    return SpannableString(text).apply {
        setSpan(UnderlineSpan(), 0, end, 0)
    }
}