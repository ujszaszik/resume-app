package hu.ujszaszik.resumeapp.resume.personal.personality

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class PersonalityData(
    var title: String = "",
    var description: String = "",
    var icon: String = ""
)