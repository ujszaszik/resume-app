package hu.ujszaszik.resumeapp.resume.skills.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.skills.SkillData

class SkillsItemCallback : DiffUtil.ItemCallback<SkillData>() {

    override fun areItemsTheSame(oldItem: SkillData, newItem: SkillData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: SkillData, newItem: SkillData): Boolean {
        return oldItem == newItem
    }
}