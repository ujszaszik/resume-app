package hu.ujszaszik.resumeapp.resume.projects

import android.content.Context
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class ExperienceRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var projectName: String
    private var projectTitle: String
    private var projectDateString: String
    private var projectDescription: String
    private var projectRoles: String
    private var projectTechnologies: String

    init {
        inflate(context, R.layout.experience_row, this)

        val array = context.obtainStyledAttributes(attrs, R.styleable.ExperienceRow)
        projectName = array.getString(R.styleable.ExperienceRow_experienceName) ?: ""
        projectTitle = array.getString(R.styleable.ExperienceRow_experienceTitle) ?: ""
        projectDateString = array.getString(R.styleable.ExperienceRow_experienceDate) ?: ""
        projectDescription = array.getString(R.styleable.ExperienceRow_experienceDescription) ?: ""
        projectRoles = array.getString(R.styleable.ExperienceRow_experienceRoles) ?: ""
        projectTechnologies =
            array.getString(R.styleable.ExperienceRow_experienceTechnologies) ?: ""

        array.recycle()

        setInitialValues()
    }

    private fun setInitialValues() {
        findTextViewById(R.id.experienceNameText).text = projectName
        findTextViewById(R.id.experienceTitleText).text = projectTitle
        findTextViewById(R.id.experienceDateText).text = projectDateString
    }

    private fun getUnderlinedUntil(text: String, end: Int): SpannableString {
        return SpannableString(text).apply {
            setSpan(UnderlineSpan(), 0, end, 0)
        }
    }

    fun setDescription(text: String) {
        findTextViewById(R.id.experienceDescriptionText).text =
            getUnderlinedUntil(text, DESCRIPTION_TITLE_LENGTH)
    }

    fun setRoles(text: String) {
        findTextViewById(R.id.experienceRolesText).text =
            getUnderlinedUntil(text, ROLES_TITLE_LENGTH)
    }

    fun setTechnologies(text: String) {
        findTextViewById(R.id.experienceTechnologiesText).text =
            getUnderlinedUntil(text, TECHNOLOGIES_TITLE_LENGTH)
    }

    companion object {
        private const val DESCRIPTION_TITLE_LENGTH = 11
        private const val ROLES_TITLE_LENGTH = 5
        private const val TECHNOLOGIES_TITLE_LENGTH = 12
    }


}