package hu.ujszaszik.resumeapp.resume.overview.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.frame.Frame
import hu.ujszaszik.resumeapp.compose.view.image.IconView
import hu.ujszaszik.resumeapp.compose.view.layout.Heights
import hu.ujszaszik.resumeapp.compose.view.layout.PositionedVertical
import hu.ujszaszik.resumeapp.compose.view.layout.Vertical
import hu.ujszaszik.resumeapp.compose.view.layout.Widths
import hu.ujszaszik.resumeapp.compose.view.text.TextView
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

@Composable
fun OverviewRow(contactData: ContactData, listener: (ContactData) -> Unit) {
    Frame(
        height = Heights.MATCH_PARENT,
        onClick = { listener.invoke(contactData) }
    ) {
        Vertical(
            marginStart = R.dimen.overview_layout_horizontal_margin,
            marginEnd = R.dimen.overview_layout_horizontal_margin,
            marginTop = R.dimen.overview_layout_top_margin,
            width = Widths.MATCH_PARENT
        ) {
            TextView(
                content = contactData.title,
                textColor = R.color.headings,
                textSize = R.dimen.overview_key_text_size
            )
            TextView(
                content = contactData.value,
                textColor = R.color.dark_grey,
                textSize = R.dimen.overview_value_text_size
            )
        }
        PositionedVertical(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            height = R.dimen.overview_arrow_icon_size
        ) {
            IconView(
                resId = R.drawable.ic_arrow,
                tint = R.color.blue_link,
                height = Heights.WRAP_CONTENT,
                width = Widths.WRAP_CONTENT,
                marginEnd = R.dimen.overview_layout_horizontal_margin
            )
        }
    }
}