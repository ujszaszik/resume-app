package hu.ujszaszik.resumeapp.resume.skills.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.ujszaszik.resumeapp.resume.skills.model.SkillData

private val skillsScreenStyle =
    Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 54.dp)

@Composable
fun SkillsScreen(context: Context, skills: List<SkillData>) {
    Column(skillsScreenStyle) {
        skills.forEach {
            SkillRow(context, it)
        }
    }
}