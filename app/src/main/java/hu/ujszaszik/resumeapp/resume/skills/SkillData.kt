package hu.ujszaszik.resumeapp.resume.skills

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class SkillData(
    var title: String = "",
    var description: String = "",
    var image: String = "",
    var stars: Double = 0.0
)