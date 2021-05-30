package hu.ujszaszik.resumeapp.resume.personal.quotes.ui

import android.content.Context
import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.image.FirestoreImage
import hu.ujszaszik.resumeapp.compose.view.layout.Vertical
import hu.ujszaszik.resumeapp.resume.personal.*
import hu.ujszaszik.resumeapp.resume.personal.quotes.model.QuoteData

@Composable
fun QuoteCard(context: Context, quotes: List<QuoteData>) {
    ProfileCard {
        quotes.forEach {
            QuoteRow(context, it)
        }
    }
}

@Composable
fun QuoteRow(context: Context, quote: QuoteData) {
    ProfileContentRow {
        Vertical {
            QuoteImage(context, quote.image)
        }
        Vertical {
            ProfileRowQuoteText(quote.quote)
            ProfileRowTitleText(quote.from)
            ProfileRowDescriptionText(quote.title)
        }
    }
}

@Composable
fun QuoteImage(context: Context, imageName: String) {
    FirestoreImage(context, imageName, R.dimen.quote_image_size)
}