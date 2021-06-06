package hu.ujszaszik.resumeapp.resume.personal.personality.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.card.CardView
import hu.ujszaszik.resumeapp.compose.view.image.ImageView
import hu.ujszaszik.resumeapp.compose.view.local.LocalContext
import hu.ujszaszik.resumeapp.extensions.getImageIdByName
import hu.ujszaszik.resumeapp.resume.personal.ProfileContentRow
import hu.ujszaszik.resumeapp.resume.personal.ProfileRowDescriptionText
import hu.ujszaszik.resumeapp.resume.personal.ProfileRowTitleText
import hu.ujszaszik.resumeapp.resume.personal.personality.model.PersonalityData


@Composable
fun PersonalityCard(remarks: List<PersonalityData>) {
    CardView(
        margin = R.dimen.margin_big,
        cornerRadius = R.dimen.card_view_corner_radius,
        elevation = R.dimen.card_view_card_elevation
    ) {
        Column {
            remarks.forEach { PersonalityRow(it) }
        }
    }
}

@Composable
fun PersonalityRow(remark: PersonalityData) {
    ProfileContentRow {
        Column {
            PersonalityIcon(remark.icon)
        }
        Column {
            ProfileRowTitleText(remark.title)
            ProfileRowDescriptionText(remark.description)
        }
    }
}

@Composable
fun PersonalityIcon(imageName: String) {
    ImageView(
        resId = LocalContext.current.getImageIdByName(imageName),
        size = R.dimen.default_image_size,
    )
}