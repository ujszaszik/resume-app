package hu.ujszaszik.resumeapp.resume.personal.personality

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findImageViewById
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class PersonalityRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var image: Drawable?
    private var name: String

    init {
        inflate(context, R.layout.personality_row, this)

        val array = context.obtainStyledAttributes(attrs, R.styleable.PersonalityRow)
        image = array.getDrawable(R.styleable.PersonalityRow_personalityImage)
        name = array.getString(R.styleable.PersonalityRow_personalityName) ?: ""
        array.recycle()

        setValues()
    }

    private fun setValues() {
        findImageViewById(R.id.languageImage).setImageDrawable(image)
        findTextViewById(R.id.quoteDescription).text = name
    }

}