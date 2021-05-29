package hu.ujszaszik.resumeapp.resume.personal

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.resume.personal.language.model.LanguageData
import hu.ujszaszik.resumeapp.resume.personal.language.ui.LanguageCard
import hu.ujszaszik.resumeapp.resume.personal.personality.model.PersonalityData
import hu.ujszaszik.resumeapp.resume.personal.personality.ui.PersonalityCard
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData

@Composable
fun ProfileScreen(
    context: Context,
    languages: List<LanguageData>?,
    remarks: List<PersonalityData>?,
    quotes: List<QuoteData>?
) {
    Column(modifier = Modifier.padding(bottom = 54.dp)) {
        languages?.let {
            ProfileHeaderText(R.string.profile_label_languages)
            LanguageCard(context, it)
        }
        remarks?.let {
            ProfileHeaderText(R.string.profile_label_personality)
            PersonalityCard(context, remarks)
        }
    }
}