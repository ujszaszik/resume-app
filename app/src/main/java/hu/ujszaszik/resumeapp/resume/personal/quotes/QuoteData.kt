package hu.ujszaszik.resumeapp.resume.personal.quotes

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