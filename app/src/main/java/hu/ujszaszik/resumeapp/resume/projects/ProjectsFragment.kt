package hu.ujszaszik.resumeapp.resume.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ujszaszik.resumeapp.databinding.FragmentProjectsBinding
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.projects.adapter.ProjectsAdapter

class ProjectsFragment : Fragment() {

    private lateinit var binding: FragmentProjectsBinding

    private lateinit var viewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getSharedViewModel()
        binding = FragmentProjectsBinding.inflate(layoutInflater)
        resetScrollView()
        observeProjects()
        return binding.root
    }

    private fun observeProjects() {
        viewModel.projects.observe(viewLifecycleOwner) {
            binding.experienceRecyclerView.adapter = ProjectsAdapter().apply {
                submitList(it)
            }
        }
    }
}