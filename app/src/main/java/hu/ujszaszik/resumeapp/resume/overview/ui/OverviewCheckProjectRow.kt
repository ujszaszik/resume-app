package hu.ujszaszik.resumeapp.resume.overview.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.layout.Heights
import hu.ujszaszik.resumeapp.compose.view.layout.Line
import hu.ujszaszik.resumeapp.compose.view.layout.Widths
import hu.ujszaszik.resumeapp.compose.view.text.TextStyles
import hu.ujszaszik.resumeapp.compose.view.text.TextView
import hu.ujszaszik.resumeapp.general.browser.BrowserAction

private val checkProjectAction: (Activity) -> Unit = {
    BrowserAction().execute(it, it.getString(R.string.app_link))
}

@Composable
fun OverviewCheckProjectRow(activity: Activity) {
    Line(
        marginTop = R.dimen.margin_heavy,
        marginBottom = R.dimen.margin_tiny,
        marginStart = R.dimen.margin_tiny,
        marginEnd = R.dimen.margin_tiny,
        layoutHeight = Heights.WRAP_CONTENT,
        layoutWidth = Widths.MATCH_PARENT,
        onClick = { checkProjectAction.invoke(activity) }
    ) { OverviewCheckProjectAtGithubText() }
}

@Composable
fun OverviewCheckProjectAtGithubText() {
    TextView(
        text = R.string.label_check_this_project,
        textColor = R.color.blue_link,
        textSize = R.dimen.normal_text_size,
        textAlign = TextAlign.Center,
        textStyle = TextStyles.UNDERLINE,
    )
}