package hu.ujszaszik.resumeapp.resume.skills

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.skills.ui.SkillsScreen

class SkillsFragment : Fragment() {
    private lateinit var viewModel: ResumeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getSharedViewModel()
    }

    @InternalComposeApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val skills = viewModel.skills.observeAsState()
                skills.value?.let {
                    SkillsScreen(requireContext(), it)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        resetScrollView()
    }
}