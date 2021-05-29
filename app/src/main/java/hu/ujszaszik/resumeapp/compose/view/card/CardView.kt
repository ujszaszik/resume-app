package hu.ujszaszik.resumeapp.compose.view.card

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@Composable
fun CardView(
    @DimenRes margin: Int = 0,
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
    @DimenRes elevation: Int = 0,
    @DimenRes cornerRadius: Int = 0,
    content: @Composable () -> Unit
) {
    Card(
        modifier = getCardPaddingModifier(margin, marginStart, marginEnd, marginTop, marginBottom),
        elevation = safeDimenResource(elevation),
        shape = RoundedCornerShape(safeDimenResource(cornerRadius))
    ) { content.invoke() }
}

@Composable
private fun getCardPaddingModifier(
    @DimenRes margin: Int = 0,
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
): Modifier {
    return if (margin != 0) Modifier.padding(12.dp)
    else Modifier.padding(
        start = safeDimenResource(marginStart),
        end = safeDimenResource(marginEnd),
        top = safeDimenResource(marginTop),
        bottom = safeDimenResource(marginBottom)
    )
}