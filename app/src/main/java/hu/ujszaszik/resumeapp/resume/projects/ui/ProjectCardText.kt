package hu.ujszaszik.resumeapp.resume.projects.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.text.TextStyles

@Composable
fun ProjectCardText(
    text: String,
    fontSize: TextUnit = 15.sp,
    colorId: Int = R.color.light_grey,
    style: TextStyles = TextStyles.NORMAL,
    isSpaced: Boolean = false
) {
    Text(
        modifier = if (isSpaced) projectCardTextSpacedModifier else projectCardTextNoSpaceModifier,
        text = text,
        fontSize = fontSize,
        color = colorResource(id = colorId),
        style = style.toComposeStyle()
    )
}

@Composable
fun ProjectCardTextPair(textPair: Pair<String, String>) {
    ProjectCardText(text = textPair.first, style = TextStyles.UNDERLINE, isSpaced = true)
    ProjectCardText(text = textPair.second)
}

val projectCardTextSpacedModifier =
    Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp)
val projectCardTextNoSpaceModifier =
    Modifier.padding(start = 12.dp, end = 12.dp)