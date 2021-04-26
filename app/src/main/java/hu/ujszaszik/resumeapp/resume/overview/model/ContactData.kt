package hu.ujszaszik.resumeapp.resume.overview.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class ContactData(
    var title: String = "",
    var value: String = ""
)