package hu.ujszaszik.resumeapp.resume.projects.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.ujszaszik.resumeapp.resume.projects.model.ProjectData

private val projectsScreenStyle =
    Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 54.dp)

@Composable
fun ProjectsScreen(projects: List<ProjectData>) {
    Column(projectsScreenStyle) {
        projects.forEach { ProjectRow(it) }
    }
}