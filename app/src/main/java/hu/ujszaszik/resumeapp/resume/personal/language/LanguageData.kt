package hu.ujszaszik.resumeapp.resume.personal.language

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class LanguageData(
    var title: String = "",
    var description: String = "",
    var flag: String = "",
    var stars: Double = 0.0
)