package hu.ujszaszik.resumeapp.resume.projects

import kotlinx.serialization.Serializable

@Serializable
data class ProjectData(
    var name: String = "",
    var title: String = "",
    var date: String = "",
    var description: String = "",
    var roles: String = "",
    var technologies: String = ""
)