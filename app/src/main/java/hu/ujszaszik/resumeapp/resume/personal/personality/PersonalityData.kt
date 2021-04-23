package hu.ujszaszik.resumeapp.resume.personal.personality

import kotlinx.serialization.Serializable

@Serializable
data class PersonalityData(
    var title: String = "",
    var description: String = "",
    var icon: String = ""
)