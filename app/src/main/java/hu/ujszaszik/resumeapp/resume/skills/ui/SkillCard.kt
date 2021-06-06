package hu.ujszaszik.resumeapp.resume.skills.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.image.ImageView
import hu.ujszaszik.resumeapp.compose.view.layout.CenteredColumn
import hu.ujszaszik.resumeapp.compose.view.layout.CenteredRow
import hu.ujszaszik.resumeapp.compose.view.local.LocalContext
import hu.ujszaszik.resumeapp.extensions.getImageIdByName
import hu.ujszaszik.resumeapp.resume.skills.model.SkillData

@Composable
fun SkillRow(skill: SkillData) {
    SkillCard {
        CenteredRow {
            SkillIcon(skill.image)
            SkillCardContent(skill)
        }
    }
}

@Composable
fun SkillCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.padding(bottom = 12.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 6.dp
    ) { content.invoke() }
}

@Composable
fun SkillIcon(imageName: String) {
    CenteredColumn(modifier = Modifier.padding(start = 16.dp)) {
        ImageView(LocalContext.current.getImageIdByName(imageName), R.dimen.default_image_size)
    }
}