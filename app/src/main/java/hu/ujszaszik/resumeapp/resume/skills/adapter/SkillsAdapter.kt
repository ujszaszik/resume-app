package hu.ujszaszik.resumeapp.resume.skills.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.skills.SkillData

class SkillsAdapter : ListAdapter<SkillData, SkillsViewHolder>(SkillsItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        return SkillsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}