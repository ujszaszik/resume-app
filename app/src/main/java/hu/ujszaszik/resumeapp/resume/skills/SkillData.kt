package hu.ujszaszik.resumeapp.resume.skills

import kotlinx.serialization.Serializable

@Serializable
data class SkillData(
    var title: String = "",
    var description: String = "",
    var image: String = "",
    var stars: Double = 0.0
)