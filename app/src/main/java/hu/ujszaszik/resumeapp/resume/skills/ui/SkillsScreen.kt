package hu.ujszaszik.resumeapp.resume.skills.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.ujszaszik.resumeapp.compose.view.local.LocalContext
import hu.ujszaszik.resumeapp.resume.skills.model.SkillData

private val skillsScreenStyle =
    Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 54.dp)

@InternalComposeApi
@Composable
fun SkillsScreen(context: Context, skills: List<SkillData>) {
    CompositionLocalProvider(LocalContext provides context) {
        Column(skillsScreenStyle) {
            skills.forEach { SkillRow(it) }
        }
    }
}