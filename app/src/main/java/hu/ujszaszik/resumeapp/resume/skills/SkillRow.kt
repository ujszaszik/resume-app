package hu.ujszaszik.resumeapp.resume.skills

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findImageViewById
import hu.ujszaszik.resumeapp.extensions.findRatingBarById
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class SkillRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var name: String
    private var description: String
    private var stars: Float
    private var skillImage: Drawable?

    init {
        inflate(context, R.layout.skills_row, this)

        val array = context.obtainStyledAttributes(attrs, R.styleable.SkillRow)
        name = array.getString(R.styleable.SkillRow_skillName) ?: ""
        description = array.getString(R.styleable.SkillRow_skillDescription) ?: ""
        stars = array.getFloat(R.styleable.SkillRow_skillStars, 0.0F)
        skillImage = array.getDrawable(R.styleable.SkillRow_skillImage)
        array.recycle()

        setInitialValues()
    }

    private fun setInitialValues() {
        findImageViewById(R.id.skillImage).setImageDrawable(skillImage)
        findTextViewById(R.id.quoteDescription).text = name
        findTextViewById(R.id.skillDescriptionText).text = description

        with(findRatingBarById(R.id.languageRating)) {
            numStars = 5
            rating = stars
            setIsIndicator(true)
        }
    }

    fun setDescription(text: String) {
        findTextViewById(R.id.skillDescriptionText).text = text
    }

}