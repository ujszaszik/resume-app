package hu.ujszaszik.resumeapp.compose.view.image

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.default.margin
import hu.ujszaszik.resumeapp.compose.view.layout.Heights
import hu.ujszaszik.resumeapp.compose.view.layout.Widths
import hu.ujszaszik.resumeapp.compose.view.layout.layoutHeight
import hu.ujszaszik.resumeapp.compose.view.layout.layoutWidth

@Composable
fun IconView(
    @DrawableRes resId: Int,
    height: Heights = Heights.MATCH_PARENT,
    width: Widths = Widths.MATCH_PARENT,
    @DimenRes marginTop: Int = R.dimen.zero,
    @DimenRes marginBottom: Int = R.dimen.zero,
    @DimenRes marginStart: Int = R.dimen.zero,
    @DimenRes marginEnd: Int = R.dimen.zero,
    @ColorRes tint: Int = 0
) {
    Icon(
        modifier = Modifier
            .layoutHeight(height)
            .layoutWidth(width)
            .margin(marginTop, marginBottom, marginStart, marginEnd),
        painter = painterResource(resId),
        tint = colorResource(tint),
        contentDescription = ""
    )
}