package hu.ujszaszik.resumeapp.resume.overview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.compose.view.separator.Separator
import hu.ujszaszik.resumeapp.general.ContactActionType
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

@Composable
fun OverviewScreen() {
    val viewModel = LocalViewModel.current
    val overviewList = viewModel.contacts.observeAsState(listOf())
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OverviewList(overviewList.value)
        OverviewCheckProjectRow(LocalActivity.current)
    }
}

@Composable
fun OverviewList(contactsList: List<ContactData>) {
    val activity = LocalActivity.current
    contactsList.forEach {
        val action = ContactActionType.getByName(activity, it.title)
        val listener: (ContactData) -> Unit = { data -> action.execute(activity, data.value) }
        OverviewRow(it, listener)
        OverviewSeparator()
    }
}

@Composable
fun OverviewSeparator() {
    Separator(
        marginStart = R.dimen.overview_layout_horizontal_margin,
        marginEnd = R.dimen.overview_layout_horizontal_margin,
        marginTop = R.dimen.margin_default
    )
}