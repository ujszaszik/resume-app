package hu.ujszaszik.resumeapp.resume.personal.personality.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData

class PersonalityItemCallback : DiffUtil.ItemCallback<PersonalityData>() {

    override fun areItemsTheSame(oldItem: PersonalityData, newItem: PersonalityData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: PersonalityData, newItem: PersonalityData): Boolean {
        return oldItem == newItem
    }
}