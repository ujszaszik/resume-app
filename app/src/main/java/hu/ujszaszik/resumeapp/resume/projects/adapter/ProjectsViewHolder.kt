package hu.ujszaszik.resumeapp.resume.projects.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.ExperienceRowBinding
import hu.ujszaszik.resumeapp.resume.projects.ProjectData

class ProjectsViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: ExperienceRowBinding

        fun from(parent: ViewGroup): ProjectsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = ExperienceRowBinding.inflate(inflater, parent, false)
            return ProjectsViewHolder(binding.root)
        }
    }

    fun bind(projectData: ProjectData) {
        binding.projectData = projectData
        binding.executePendingBindings()
    }
}