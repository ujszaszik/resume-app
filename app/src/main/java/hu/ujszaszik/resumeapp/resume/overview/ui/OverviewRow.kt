package hu.ujszaszik.resumeapp.resume.overview.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

@SuppressLint("ModifierFactoryExtensionFunction")
private fun overviewRowStyle(
    contactData: ContactData,
    listener: (ContactData) -> Unit
): Modifier {
    return Modifier
        .clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = { listener.invoke(contactData) })
        .fillMaxHeight()
}

@Composable
fun OverviewRow(contactData: ContactData, listener: (ContactData) -> Unit) {
    Box(overviewRowStyle(contactData, listener)) {
        OverviewText(contactData)
        OverviewIconView()
    }
}

private val overviewTextStyle =
    Modifier
        .fillMaxWidth()
        .padding(start = 30.dp, end = 30.dp, top = 30.dp)

@Composable
fun OverviewText(contactData: ContactData) {
    Column(overviewTextStyle) {
        Text(text = contactData.title, color = colorResource(R.color.headings), fontSize = 13.sp)
        Text(text = contactData.value, color = colorResource(R.color.dark_grey), fontSize = 18.sp)
    }
}

private val overviewIconStyle =
    Modifier
        .height(70.dp)
        .fillMaxWidth()
        .padding(end = 30.dp)

@Composable
fun OverviewIconView() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
        modifier = overviewIconStyle
    ) { OverviewIcon() }
}

@Composable
fun OverviewIcon() {
    Icon(
        imageVector = Icons.Rounded.ArrowForward,
        tint = colorResource(id = R.color.blue_link),
        contentDescription = ""
    )
}