package hu.ujszaszik.resumeapp.compose.view.layout

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@Composable
fun Vertical(
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
    @DimenRes height: Int = 0,
    intrinsicSize: IntrinsicSize = IntrinsicSize.Max,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                start = safeDimenResource(marginStart),
                end = safeDimenResource(marginEnd),
                top = safeDimenResource(marginTop),
                bottom = safeDimenResource(marginBottom)
            )
            .verticalHeight(height, intrinsicSize),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) { content.invoke() }
}

@Composable
fun Modifier.verticalHeight(
    @DimenRes height: Int = 0,
    intrinsicSize: IntrinsicSize = IntrinsicSize.Max
): Modifier {
    return if (height != 0) apply { height(safeDimenResource(height)) }
    else apply { height(intrinsicSize) }
}