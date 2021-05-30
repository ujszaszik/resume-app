package hu.ujszaszik.resumeapp.resume.personal

import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.card.CardView
import hu.ujszaszik.resumeapp.compose.view.layout.Vertical

@Composable
fun ProfileCard(content: @Composable () -> Unit) {
    CardView(
        margin = R.dimen.margin_big,
        cornerRadius = R.dimen.card_view_corner_radius,
        elevation = R.dimen.card_view_card_elevation
    ) { Vertical { content.invoke() } }
}