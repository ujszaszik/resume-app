package hu.ujszaszik.resumeapp.resume.projects.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.text.TextStyles
import hu.ujszaszik.resumeapp.resume.projects.model.ProjectData
import hu.ujszaszik.resumeapp.resume.projects.model.descriptionPair
import hu.ujszaszik.resumeapp.resume.projects.model.rolesPair
import hu.ujszaszik.resumeapp.resume.projects.model.technologiesPair

@Composable
fun ProjectRow(project: ProjectData) {
    ProjectCard {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            ProjectCardLeftColoredLayout()
            ProjectCardContent(project)
        }
    }
}

@Composable
fun ProjectCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.padding(bottom = 12.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 6.dp
    ) { content.invoke() }
}

@Composable
fun ProjectCardLeftColoredLayout() {
    Divider(
        color = colorResource(id = R.color.colorAccent),
        modifier = Modifier
            .fillMaxHeight()
            .width(5.dp)
    )
}

@Composable
fun ProjectCardContent(project: ProjectData) {
    Column(modifier = Modifier.padding(end = 16.dp, top = 8.dp, bottom = 8.dp)) {
        ProjectCardText(text = project.name, 18.sp, R.color.headings, TextStyles.BOLD)
        ProjectCardText(text = project.title, 16.sp, R.color.dark_grey, TextStyles.BOLD)
        ProjectCardText(text = project.date, style = TextStyles.ITALIC)
        ProjectCardTextPair(project.descriptionPair)
        ProjectCardTextPair(project.rolesPair)
        ProjectCardTextPair(project.technologiesPair)
    }
}