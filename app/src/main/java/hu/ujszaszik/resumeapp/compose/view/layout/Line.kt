package hu.ujszaszik.resumeapp.compose.view.layout

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@Composable
fun Line(
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
    width: Widths,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(
                start = safeDimenResource(marginStart),
                end = safeDimenResource(marginEnd),
                top = safeDimenResource(marginTop),
                bottom = safeDimenResource(marginBottom)
            )
            .width(getIntrinsicWidth(width))
    ) { content.invoke() }
}

private fun getIntrinsicWidth(width: Widths): IntrinsicSize {
    return when (width) {
        Widths.WRAP_CONTENT -> IntrinsicSize.Min
        Widths.MATCH_PARENT -> IntrinsicSize.Max
    }
}