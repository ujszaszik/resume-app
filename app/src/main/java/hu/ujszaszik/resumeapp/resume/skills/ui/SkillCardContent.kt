package hu.ujszaszik.resumeapp.resume.skills.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.custom.RatingBar
import hu.ujszaszik.resumeapp.compose.view.text.TextStyles
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
    RatingBar(
        value = value,
        size = R.dimen.skills_rating_size,
        padding = R.dimen.padding_default
    )
}