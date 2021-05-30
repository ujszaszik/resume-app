package hu.ujszaszik.resumeapp.compose.view.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class Widths {
    WRAP_CONTENT, MATCH_PARENT, INTRINSIC_MAX, INTRINSIC_MIN
}

@Composable
fun Modifier.layoutWidth(width: Widths): Modifier {
    return when (width) {
        Widths.WRAP_CONTENT -> apply { wrapContentWidth() }
        Widths.MATCH_PARENT -> apply { fillMaxWidth() }
        Widths.INTRINSIC_MAX -> apply { width(IntrinsicSize.Max) }
        Widths.INTRINSIC_MIN -> apply { width(IntrinsicSize.Min) }
    }
}

enum class Heights {
    WRAP_CONTENT, MATCH_PARENT, INTRINSIC_MAX, INTRINSIC_MIN
}

@Composable
fun Modifier.layoutHeight(height: Heights): Modifier {
    return when (height) {
        Heights.WRAP_CONTENT -> apply { wrapContentHeight() }
        Heights.MATCH_PARENT -> apply { fillMaxHeight() }
        Heights.INTRINSIC_MAX -> apply { height(IntrinsicSize.Max) }
        Heights.INTRINSIC_MIN -> apply { height(IntrinsicSize.Min) }
    }
}