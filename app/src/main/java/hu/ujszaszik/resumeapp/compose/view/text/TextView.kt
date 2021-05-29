package hu.ujszaszik.resumeapp.compose.view.text

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextView(
    content: String = "",
    @StringRes text: Int = 0,
    @DimenRes marginStart: Int = 0,
    @DimenRes marginEnd: Int = 0,
    @DimenRes marginTop: Int = 0,
    @DimenRes marginBottom: Int = 0,
    @ColorRes textColor: Int = 0,
    @DimenRes textSize: Int = 0,
    textStyle: TextStyles = TextStyles.NORMAL,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = Modifier
            .padding(
                start = safeDimenResource(marginStart),
                end = safeDimenResource(marginEnd),
                top = safeDimenResource(marginTop),
                bottom = safeDimenResource(marginBottom)
            ),
        text = textResource(content, text),
        color = colorResource(id = textColor),
        fontSize = textSizeResource(id = textSize),
        style = textStyle.composeStyle,
        textAlign = textAlign
    )
}

@Composable
fun textResource(content: String, @StringRes resId: Int = 0): String {
    return if (content.isNotEmpty()) return content
    else stringResource(id = resId)
}

@Composable
fun textSizeResource(@DimenRes id: Int): TextUnit {
    val context = LocalContext.current
    val density = LocalDensity.current
    val spValue = context.resources.getDimension(id)
    val value = spValue / density.density
    return value.sp
}

@Composable
fun safeDimenResource(@DimenRes resId: Int): Dp {
    return if (resId != 0) dimensionResource(id = resId)
    else 0.dp
}