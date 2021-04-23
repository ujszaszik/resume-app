package hu.ujszaszik.resumeapp.resume.overview.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.findTextViewById


class OverviewRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.overview_row, this)
    }

    private fun setTitle(text: String) {
        findTextViewById(R.id.overviewTitle).text = text
    }

    fun setValue(text: String) {
        findTextViewById(R.id.overviewValue).text = text
    }

}