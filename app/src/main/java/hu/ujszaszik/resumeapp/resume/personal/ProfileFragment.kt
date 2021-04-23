package hu.ujszaszik.resumeapp.resume.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ujszaszik.resumeapp.databinding.FragmentProfileBinding
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.personal.language.adapter.LanguageAdapter
import hu.ujszaszik.resumeapp.resume.personal.personality.adapter.PersonalityAdapter
import hu.ujszaszik.resumeapp.resume.personal.quotes.adapter.QuoteAdapter

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var viewModel: ResumeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getSharedViewModel()
        binding = FragmentProfileBinding.inflate(layoutInflater)
        resetScrollView()
        observeLanguages()
        observePersonalityData()
        observeQuotes()
        return binding.root
    }

    private fun observeLanguages() {
        viewModel.languages.observe(viewLifecycleOwner) {
            binding.languageRecyclerView.adapter = LanguageAdapter().apply {
                submitList(it)
            }
        }
    }

    private fun observePersonalityData() {
        viewModel.personalityData.observe(viewLifecycleOwner) {
            binding.personalityRecyclerView.adapter = PersonalityAdapter().apply {
                submitList(it)
            }
        }
    }

    private fun observeQuotes() {
        viewModel.quotes.observe(viewLifecycleOwner) {
            binding.quotesRecyclerView.adapter = QuoteAdapter().apply {
                submitList(it)
            }
        }
    }
}