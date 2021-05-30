package hu.ujszaszik.resumeapp.resume.personal.quotes.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class QuoteData(
    var from: String = "",
    var title: String = "",
    var quote: String = "",
    var image: String = ""
)