package hu.ujszaszik.resumeapp.compose.view.image

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.core.graphics.drawable.toBitmap
import com.google.firebase.storage.FirebaseStorage
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.text.safeDimenResource
import hu.ujszaszik.resumeapp.extensions.getImage

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

@Composable
fun CircleImageBitmap(
    bitmap: Bitmap,
    @DimenRes size: Int,
    @DimenRes borderWidth: Int = 0,
    @ColorRes borderColor: Int = R.color.colorPrimary
) {
    var modifier = Modifier
        .size(safeDimenResource(size))
        .clip(CircleShape)
    if (borderWidth != 0) {
        modifier = modifier.border(
            safeDimenResource(borderWidth),
            colorResource(borderColor),
            CircleShape
        )
    }
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun ImageBitmap(bitmap: Bitmap, @DimenRes size: Int) {
    Image(
        modifier = Modifier.size(safeDimenResource(size)),
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "",
    )
}

@Composable
fun FirestoreImage(
    context: Context,
    storedName: String,
    @DimenRes size: Int,
    @DimenRes borderWidth: Int = 0,
    @ColorRes borderColor: Int = R.color.colorPrimary
) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    bitmap?.let { CircleImageBitmap(it, size, borderWidth, borderColor) }

    FirebaseStorage.getInstance()
        .getImage(context.resources, storedName)
        .subscribe { bitmap = it.toBitmap() }
}