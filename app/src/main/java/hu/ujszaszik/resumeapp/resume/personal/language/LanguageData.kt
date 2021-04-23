package hu.ujszaszik.resumeapp.resume.personal.language

import kotlinx.serialization.Serializable

@Serializable
data class LanguageData(
    var title: String = "",
    var description: String = "",
    var flag: String = "",
    var stars: Double = 0.0
)