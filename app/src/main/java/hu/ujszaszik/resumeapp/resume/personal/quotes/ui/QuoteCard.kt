package hu.ujszaszik.resumeapp.resume.personal.quotes.ui

import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.image.FirestoreImage
import hu.ujszaszik.resumeapp.compose.view.layout.Vertical
import hu.ujszaszik.resumeapp.compose.view.local.LocalContext
import hu.ujszaszik.resumeapp.resume.personal.*
import hu.ujszaszik.resumeapp.resume.personal.quotes.model.QuoteData

@Composable
fun QuoteCard(quotes: List<QuoteData>) {
    ProfileCard { quotes.forEach { QuoteRow(it) } }
}

@Composable
fun QuoteRow(quote: QuoteData) {
    ProfileContentRow {
        Vertical {
            QuoteImage(quote.image)
        }
        Vertical {
            ProfileRowQuoteText(quote.quote)
            ProfileRowTitleText(quote.from)
            ProfileRowDescriptionText(quote.title)
        }
    }
}

@Composable
fun QuoteImage(imageName: String) {
    FirestoreImage(LocalContext.current, imageName, R.dimen.quote_image_size)
}