package hu.ujszaszik.resumeapp.resume.overview.model

import kotlinx.serialization.Serializable

@Serializable
data class ContactData(
    var title: String = "",
    var value: String = ""
)