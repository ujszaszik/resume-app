package hu.ujszaszik.resumeapp.resume.personal

import android.content.Context
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
    context: Context,
    languages: List<LanguageData>?,
    remarks: List<PersonalityData>?,
    quotes: List<QuoteData>?
) {
    Vertical(marginBottom = R.dimen.bottom_navigation_view_height) {
        languages?.let { LanguageContent(context, it) }
        remarks?.let { PersonalityContent(context, it) }
        quotes?.let { QuoteContent(context, it) }
    }
}

@Composable
fun LanguageContent(context: Context, languages: List<LanguageData>) {
    ProfileHeaderText(R.string.profile_label_languages)
    LanguageCard(context, languages)
}

@Composable
fun PersonalityContent(context: Context, remarks: List<PersonalityData>) {
    ProfileHeaderText(R.string.profile_label_personality)
    PersonalityCard(context, remarks)
}

@Composable
fun QuoteContent(context: Context, quotes: List<QuoteData>) {
    ProfileHeaderText(R.string.profile_label_quotes)
    QuoteCard(context, quotes)
}