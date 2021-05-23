package hu.ujszaszik.resumeapp.compose.text

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

enum class TextStyles {
    NORMAL,
    BOLD,
    ITALIC,
    UNDERLINE;

    fun toComposeStyle(): TextStyle {
        return when (this) {
            NORMAL -> TextStyle.Default
            BOLD -> TextStyle(fontWeight = FontWeight.Bold)
            ITALIC -> TextStyle(fontStyle = FontStyle.Italic)
            UNDERLINE -> TextStyle(textDecoration = TextDecoration.Underline)
        }
    }
}