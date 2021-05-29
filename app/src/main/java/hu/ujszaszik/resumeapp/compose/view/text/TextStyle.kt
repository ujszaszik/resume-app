package hu.ujszaszik.resumeapp.compose.view.text

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

enum class TextStyles(val composeStyle: TextStyle) {
    NORMAL(TextStyle.Default),
    BOLD(TextStyle(fontWeight = FontWeight.Bold)),
    ITALIC(TextStyle(fontStyle = FontStyle.Italic)),
    UNDERLINE(TextStyle(textDecoration = TextDecoration.Underline))
}