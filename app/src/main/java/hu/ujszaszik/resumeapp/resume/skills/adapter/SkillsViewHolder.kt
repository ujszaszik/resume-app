package hu.ujszaszik.resumeapp.resume.skills.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.SkillsRowBinding
import hu.ujszaszik.resumeapp.resume.skills.SkillData

class SkillsViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: SkillsRowBinding

        fun from(parent: ViewGroup): SkillsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = SkillsRowBinding.inflate(inflater, parent, false)
            return SkillsViewHolder(binding.root)
        }
    }

    fun bind(skillData: SkillData) {
        binding.skillData = skillData
        binding.executePendingBindings()
    }
}