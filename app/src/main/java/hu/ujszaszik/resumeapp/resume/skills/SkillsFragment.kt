package hu.ujszaszik.resumeapp.resume.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ujszaszik.resumeapp.databinding.FragmentSkillsBinding
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.skills.adapter.SkillsAdapter

class SkillsFragment : Fragment() {

    private lateinit var binding: FragmentSkillsBinding

    private lateinit var viewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getSharedViewModel()
        binding = FragmentSkillsBinding.inflate(inflater)
        resetScrollView()
        observeSkills()
        return binding.root
    }

    private fun observeSkills() {
        viewModel.skills.observe(viewLifecycleOwner) {
            binding.skillsRecyclerView.adapter = SkillsAdapter().apply {
                submitList(it)
            }
        }
    }

}