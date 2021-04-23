package hu.ujszaszik.resumeapp.resume.personal.personality.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.PersonalityRowBinding
import hu.ujszaszik.resumeapp.resume.personal.personality.PersonalityData

class PersonalityViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: PersonalityRowBinding

        fun from(parent: ViewGroup): PersonalityViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = PersonalityRowBinding.inflate(inflater, parent, false)
            return PersonalityViewHolder(binding.root)
        }
    }

    fun bind(personalityData: PersonalityData) {
        binding.personalityData = personalityData
        binding.executePendingBindings()
    }
}