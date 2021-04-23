package hu.ujszaszik.resumeapp.resume.overview.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.OverviewRowBinding
import hu.ujszaszik.resumeapp.general.ContactActionType
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData
import hu.ujszaszik.resumeapp.resume.overview.model.ContactDataOnClickListener

class OverviewViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: OverviewRowBinding

        fun from(parent: ViewGroup): OverviewViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = OverviewRowBinding.inflate(inflater, parent, false)
            return OverviewViewHolder(binding.root)
        }
    }

    fun bind(activity: Activity, contactData: ContactData) {
        binding.contactData = contactData
        binding.onClickListener = getActualListener(activity, contactData)
        binding.executePendingBindings()
    }

    private fun getActualListener(
        activity: Activity,
        contactData: ContactData
    ): ContactDataOnClickListener {
        val action = ContactActionType.getByName(binding.root.context, contactData.title)
        return ContactDataOnClickListener { action.execute(activity, contactData.value) }
    }
}