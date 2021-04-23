package hu.ujszaszik.resumeapp.resume.personal.quotes

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findImageViewById
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class QuoteRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.quote_row, this)
    }

    fun setDescription(text: String) {
        findTextViewById(R.id.quoteDescription).text = text
    }

    fun setFrom(text: String) {
        findTextViewById(R.id.quoteFrom).text = text
    }

    fun setFromTitle(text: String) {
        findTextViewById(R.id.quoteFromTitle).text = text
    }

    fun setImage(bitmap: Bitmap) {
        findImageViewById(R.id.languageImage).setImageBitmap(bitmap)
    }

}