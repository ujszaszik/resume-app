package hu.ujszaszik.resumeapp.compose.view.image

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.ujszaszik.resumeapp.R

@Composable
fun ImageView(@DrawableRes resId: Int, @DimenRes size: Int, @DimenRes padding: Int = R.dimen.zero) {
    Image(
        painter = painterResource(resId),
        contentDescription = "",
        modifier = Modifier
            .size(dimensionResource(size))
            .padding(dimensionResource(padding))
    )
}