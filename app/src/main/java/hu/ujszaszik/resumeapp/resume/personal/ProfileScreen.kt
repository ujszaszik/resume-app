package hu.ujszaszik.resumeapp.resume.personal

import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.layout.Vertical
import hu.ujszaszik.resumeapp.resume.personal.language.model.LanguageData
import hu.ujszaszik.resumeapp.resume.personal.language.ui.LanguageCard
import hu.ujszaszik.resumeapp.resume.personal.personality.model.PersonalityData
import hu.ujszaszik.resumeapp.resume.personal.personality.ui.PersonalityCard
import hu.ujszaszik.resumeapp.resume.personal.quotes.model.QuoteData
import hu.ujszaszik.resumeapp.resume.personal.quotes.ui.QuoteCard

@Composable
fun ProfileScreen(
    languages: List<LanguageData>?,
    remarks: List<PersonalityData>?,
    quotes: List<QuoteData>?
) {
    Vertical(marginBottom = R.dimen.bottom_navigation_view_height) {
        languages?.let { LanguageContent(it) }
        remarks?.let { PersonalityContent(it) }
        quotes?.let { QuoteContent(it) }
    }
}

@Composable
fun LanguageContent(languages: List<LanguageData>) {
    ProfileHeaderText(R.string.profile_label_languages)
    LanguageCard(languages)
}

@Composable
fun PersonalityContent(remarks: List<PersonalityData>) {
    ProfileHeaderText(R.string.profile_label_personality)
    PersonalityCard(remarks)
}

@Composable
fun QuoteContent(quotes: List<QuoteData>) {
    ProfileHeaderText(R.string.profile_label_quotes)
    QuoteCard(quotes)
}