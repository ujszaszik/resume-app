package hu.ujszaszik.resumeapp.resume.projects

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.projects.ui.ProjectsScreen

class ProjectsFragment : Fragment() {
    private lateinit var viewModel: ResumeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getSharedViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val projects = viewModel.projects.observeAsState()
                projects.value?.let { ProjectsScreen(it) }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        resetScrollView()
    }
}