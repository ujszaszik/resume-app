package hu.ujszaszik.resumeapp.compose.view.layout

import androidx.annotation.DimenRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@Composable
fun Line(
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
    layoutWidth: Widths = Widths.MATCH_PARENT,
    layoutHeight: Heights = Heights.MATCH_PARENT,
    onClick: () -> Unit = {},
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
            .layoutWidth(layoutWidth)
            .layoutHeight(layoutHeight)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onClick.invoke() })
    ) { content.invoke() }
}