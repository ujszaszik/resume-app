package hu.ujszaszik.resumeapp.resume.personal

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.text.TextStyles
import hu.ujszaszik.resumeapp.compose.view.text.TextView
import hu.ujszaszik.resumeapp.extensions.asQuote

@Composable
fun ProfileHeaderText(@StringRes textId: Int) {
    TextView(
        text = textId,
        marginStart = R.dimen.margin_default,
        marginTop = R.dimen.margin_big,
        marginEnd = R.dimen.margin_default,
        textColor = R.color.headings,
        textSize = R.dimen.default_text_size,
        textStyle = TextStyles.BOLD
    )
}

@Composable
fun ProfileRowTitleText(title: String) {
    TextView(
        content = title,
        marginStart = R.dimen.margin_extended,
        marginEnd = R.dimen.margin_default,
        marginTop = R.dimen.margin_tiny,
        textColor = R.color.dark_grey,
        textSize = R.dimen.normal_text_size,
        textStyle = TextStyles.BOLD,
    )
}

@Composable
fun ProfileRowDescriptionText(description: String) {
    TextView(
        content = description,
        marginStart = R.dimen.margin_extended,
        marginEnd = R.dimen.margin_default,
        marginTop = R.dimen.margin_minimum,
        textColor = R.color.dark_grey,
        textSize = R.dimen.normal_text_size,
    )
}

@Composable
fun ProfileRowQuoteText(quoteText: String) {
    TextView(
        content = quoteText.asQuote,
        marginStart = R.dimen.margin_extended,
        marginEnd = R.dimen.margin_default,
        marginTop = R.dimen.margin_minimum,
        textColor = R.color.dark_grey,
        textSize = R.dimen.normal_text_size,
        textStyle = TextStyles.ITALIC
    )
}