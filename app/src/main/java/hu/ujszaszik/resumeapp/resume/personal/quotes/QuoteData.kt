package hu.ujszaszik.resumeapp.resume.personal.quotes

import kotlinx.serialization.Serializable

@Serializable
data class QuoteData(
    var from: String = "",
    var title: String = "",
    var quote: String = "",
    var image: String = ""
)