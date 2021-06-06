package hu.ujszaszik.resumeapp.resume.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel

class ProfileFragment : Fragment() {

    private lateinit var viewModel: ResumeViewModel

    @InternalComposeApi
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