package hu.ujszaszik.resumeapp.resume.projects.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class ProjectData(
    var name: String = "",
    var title: String = "",
    var date: String = "",
    var description: String = "",
    var roles: String = "",
    var technologies: String = ""
)