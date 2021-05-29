package hu.ujszaszik.resumeapp.compose.view.custom

import androidx.annotation.DimenRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.image.ImageView

@Composable
fun RatingBar(
    value: Double,
    @DimenRes size: Int,
    @DimenRes padding: Int,
    verticalAlign: Alignment.Vertical = Alignment.Top,
    horizontalAlign: Arrangement.Horizontal = Arrangement.Start
) {
    Row(
        modifier = Modifier
            .padding(dimensionResource(padding))
            .fillMaxWidth(),
        verticalAlignment = verticalAlign,
        horizontalArrangement = horizontalAlign
    ) { RatingBarContent(value, size) }
}

@Composable
fun RatingBarContent(value: Double, @DimenRes size: Int) {
    val wholePart = value.toInt()
    val isHalf: Boolean = value - wholePart != 0.0
    for (i in 0 until wholePart) ImageView(R.drawable.ic_star_gold, size)
    if (isHalf) ImageView(R.drawable.ic_star_half_gold, size)
}