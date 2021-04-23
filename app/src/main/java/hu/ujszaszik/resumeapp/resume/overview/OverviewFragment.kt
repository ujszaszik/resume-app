package hu.ujszaszik.resumeapp.resume.overview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ujszaszik.resumeapp.R
import com.ujszaszik.resumeapp.databinding.FragmentOverviewBinding
import hu.ujszaszik.resumeapp.extensions.getSharedViewModel
import hu.ujszaszik.resumeapp.extensions.observeNotNull
import hu.ujszaszik.resumeapp.extensions.resetScrollView
import hu.ujszaszik.resumeapp.general.browser.BrowserAction
import hu.ujszaszik.resumeapp.resume.ResumeViewModel
import hu.ujszaszik.resumeapp.resume.overview.adapter.OverviewAdapter
import hu.ujszaszik.resumeapp.resume.overview.model.ContactDataOnClickListener

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding

    private lateinit var viewModel: ResumeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = getSharedViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(layoutInflater)
        bindLoadingStatus()
        bindCheckSourceCodeListener()
        observeContacts()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        resetScrollView()
    }

    private fun bindLoadingStatus() {
        viewModel.isLoading.observeNotNull(viewLifecycleOwner) {
            binding.isLoading = it
        }
    }

    private fun bindCheckSourceCodeListener() {
        binding.onClickListener = ContactDataOnClickListener {
            BrowserAction().execute(requireActivity(), getString(R.string.app_link))
        }
    }

    private fun observeContacts() {
        viewModel.contacts.observe(viewLifecycleOwner) {
            binding.overviewRecyclerView.adapter =
                OverviewAdapter(requireActivity()).apply { submitList(it) }
        }
    }

}