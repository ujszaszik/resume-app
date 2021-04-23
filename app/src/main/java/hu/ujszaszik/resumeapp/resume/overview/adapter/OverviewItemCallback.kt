package hu.ujszaszik.resumeapp.resume.overview.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

class OverviewItemCallback : DiffUtil.ItemCallback<ContactData>() {

    override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
        return oldItem == newItem
    }
}