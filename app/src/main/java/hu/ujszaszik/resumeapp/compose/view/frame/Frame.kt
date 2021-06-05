package hu.ujszaszik.resumeapp.compose.view.frame

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.ujszaszik.resumeapp.compose.view.layout.Heights
import hu.ujszaszik.resumeapp.compose.view.layout.layoutHeight

@Composable
fun Frame(
    height: Heights = Heights.MATCH_PARENT,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onClick.invoke() })
            .layoutHeight(height)
    ) {
        content.invoke()
    }
}