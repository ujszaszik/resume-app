package hu.ujszaszik.resumeapp.resume.overview.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.overview.model.ContactData

class OverviewAdapter(private val activity: Activity) :
    ListAdapter<ContactData, OverviewViewHolder>(OverviewItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.bind(activity, getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}