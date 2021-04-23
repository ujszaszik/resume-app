package hu.ujszaszik.resumeapp.resume.personal.language

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findImageViewById
import hu.ujszaszik.resumeapp.extensions.findRatingBarById
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class LanguageRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var languageFlag: Drawable?
    private var languageName: String
    private var languageRating: Float

    init {
        inflate(context, R.layout.language_row, this)

        val array = context.obtainStyledAttributes(attrs, R.styleable.LanguageRow)
        languageFlag = array.getDrawable(R.styleable.LanguageRow_languageFlag)
        languageName = array.getString(R.styleable.LanguageRow_languageName) ?: ""
        languageRating = array.getFloat(R.styleable.LanguageRow_languageRating, 0.0F)
        array.recycle()

        setValues()
    }

    private fun setValues() {
        findImageViewById(R.id.languageImage).setImageDrawable(languageFlag)
        findTextViewById(R.id.quoteDescription).text = languageName

        with(findRatingBarById(R.id.languageRating)) {
            setIsIndicator(true)
            rating = languageRating
        }
    }

    fun setDescription(text: String) {
        findTextViewById(R.id.quoteFrom).text = text
    }

}