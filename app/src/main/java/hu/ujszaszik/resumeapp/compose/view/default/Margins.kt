package hu.ujszaszik.resumeapp.compose.view.default

import android.annotation.SuppressLint
import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Composable
fun Modifier.margin(
    @DimenRes marginTop: Int = R.dimen.zero,
    @DimenRes marginBottom: Int = R.dimen.zero,
    @DimenRes marginStart: Int = R.dimen.zero,
    @DimenRes marginEnd: Int = R.dimen.zero,
): Modifier {
    return padding(
        top = safeDimenResource(marginTop),
        bottom = safeDimenResource(marginBottom),
        start = safeDimenResource(marginStart),
        end = safeDimenResource(marginEnd)
    )
}