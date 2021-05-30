package hu.ujszaszik.resumeapp.resume.personal

import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.layout.Line
import hu.ujszaszik.resumeapp.compose.view.layout.Widths

@Composable
fun ProfileContentRow(content: @Composable () -> Unit) {
    Line(
        layoutWidth = Widths.INTRINSIC_MAX,
        marginTop = R.dimen.margin_big,
        marginBottom = R.dimen.margin_default,
        marginStart = R.dimen.margin_default,
        marginEnd = R.dimen.margin_default
    ) { content.invoke() }
}