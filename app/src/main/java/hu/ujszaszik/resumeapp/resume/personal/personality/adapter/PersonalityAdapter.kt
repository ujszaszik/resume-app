package hu.ujszaszik.resumeapp.resume.personal.personality.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData

class PersonalityAdapter :
    ListAdapter<PersonalityData, PersonalityViewHolder>(PersonalityItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalityViewHolder {
        return PersonalityViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PersonalityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}