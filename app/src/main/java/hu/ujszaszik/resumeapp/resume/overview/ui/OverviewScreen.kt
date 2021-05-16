package hu.ujszaszik.resumeapp.resume.overview.ui

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.ujszaszik.resumeapp.general.ContactActionType
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

@Composable
fun OverviewScreen(viewModel: ResumeViewModel, activity: Activity) {
    val overviewList = viewModel.contacts.observeAsState(listOf())
    Column {
        OverviewList(overviewList.value, activity)
        OverviewCheckProjectRow(activity)
    }
}

@Composable
fun OverviewList(contactsList: List<ContactData>, activity: Activity) {
    contactsList.forEach {
        val action = ContactActionType.getByName(activity, it.title)
        val listener: (ContactData) -> Unit = { data -> action.execute(activity, data.value) }
        OverviewRow(contactData = it, listener)
        Divider(modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp))
    }
}