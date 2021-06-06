package hu.ujszaszik.resumeapp.resume.personal.language.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.card.CardView
import hu.ujszaszik.resumeapp.compose.view.custom.RatingBar
import hu.ujszaszik.resumeapp.compose.view.image.ImageView
import hu.ujszaszik.resumeapp.compose.view.local.LocalContext
import hu.ujszaszik.resumeapp.extensions.getImageIdByName
import hu.ujszaszik.resumeapp.resume.personal.ProfileContentRow
import hu.ujszaszik.resumeapp.resume.personal.ProfileRowDescriptionText
import hu.ujszaszik.resumeapp.resume.personal.ProfileRowTitleText
import hu.ujszaszik.resumeapp.resume.personal.language.model.LanguageData

@Composable
fun LanguageCard(languages: List<LanguageData>) {
    CardView(
        margin = R.dimen.margin_big,
        cornerRadius = R.dimen.card_view_corner_radius,
        elevation = R.dimen.card_view_card_elevation
    ) {
        Column { languages.forEach { LanguageRow(it) } }
    }
}

@Composable
fun LanguageRow(language: LanguageData) {
    ProfileContentRow {
        Column {
            LanguageIcon(language.flag)
        }
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                ProfileRowTitleText(language.title)
                LanguageRatingBar(language.stars)
            }
            Row {
                ProfileRowDescriptionText(language.description)
            }
        }
    }
}

@Composable
fun LanguageIcon(imageName: String) {
    ImageView(
        resId = LocalContext.current.getImageIdByName(imageName),
        size = R.dimen.language_image_size,
    )
}

@Composable
fun LanguageRatingBar(value: Double) {
    RatingBar(
        value = value,
        size = R.dimen.language_rating_size,
        padding = R.dimen.padding_tiny,
        horizontalAlign = Arrangement.End
    )
}