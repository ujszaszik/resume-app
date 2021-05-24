package hu.ujszaszik.resumeapp.resume.skills.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.text.TextStyles
import hu.ujszaszik.resumeapp.compose.view.ImageView
import hu.ujszaszik.resumeapp.resume.skills.model.SkillData

@Composable
fun SkillCardContent(skill: SkillData) {
    Column(modifier = Modifier.width(IntrinsicSize.Max)) {
        SkillsTitleText(skill.title)
        SkillsDescriptionText(skill.description)
        SkillsRatingBar(skill.stars)
    }
}

@Composable
fun SkillsTitleText(title: String) {
    Text(
        modifier = Modifier
            .padding(
                start = 16.dp,
                top = 12.dp,
                end = 16.dp
            ),
        text = title,
        color = colorResource(R.color.headings),
        fontSize = 20.sp,
        style = TextStyles.BOLD.composeStyle
    )
}

@Composable
fun SkillsDescriptionText(title: String) {
    Text(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp),
        text = title,
        color = colorResource(R.color.dark_grey),
        fontSize = 15.sp
    )
}

@Composable
fun SkillsRatingBar(value: Double) {
    val wholePart = value.toInt()
    val isHalf: Boolean = value - wholePart != 0.0
    Row(modifier = Modifier.padding(12.dp)) {
        for (i in 0 until wholePart) ImageView(R.drawable.ic_star_gold, 36.dp)
        if (isHalf) ImageView(R.drawable.ic_star_half_gold, 36.dp)
    }
}