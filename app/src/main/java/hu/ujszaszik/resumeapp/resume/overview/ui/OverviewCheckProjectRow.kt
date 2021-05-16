package hu.ujszaszik.resumeapp.resume.overview.ui

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.general.browser.BrowserAction

private val checkProjectAction: (Activity) -> Unit = {
    BrowserAction().execute(it, it.getString(R.string.app_link))
}

private val checkProjectRowStyle: (Activity) -> Modifier = {
    Modifier
        .padding(40.dp)
        .wrapContentHeight()
        .clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = { checkProjectAction(it) })
}

@Composable
fun OverviewCheckProjectRow(activity: Activity) {
    Row(modifier = checkProjectRowStyle(activity)) {
        OverviewCheckProjectAtGithubText()
    }
}

@Composable
fun OverviewCheckProjectAtGithubText() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.label_check_this_project),
        color = colorResource(R.color.blue_link),
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        style = TextStyle(textDecoration = TextDecoration.Underline)
    )
}