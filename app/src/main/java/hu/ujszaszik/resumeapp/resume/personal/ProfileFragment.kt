package hu.ujszaszik.resumeapp.resume.personal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getSharedViewModel()
        resetScrollView()
        return ComposeView(requireContext()).apply {
            setContent { ProfileContent(requireContext(), viewModel) }
        }
    }
}

@Composable
fun ProfileContent(context: Context, viewModel: ResumeViewModel) {
    val languages = viewModel.languages.observeAsState()
    val remarks = viewModel.personalityData.observeAsState()
    val quotes = viewModel.quotes.observeAsState()
    ProfileScreen(
        context = context,
        languages = languages.value,
        remarks = remarks.value,
        quotes = quotes.value
    )
}