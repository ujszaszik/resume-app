package hu.ujszaszik.resumeapp.resume.projects.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.projects.ProjectData

class ProjectsItemCallback : DiffUtil.ItemCallback<ProjectData>() {

    override fun areItemsTheSame(oldItem: ProjectData, newItem: ProjectData): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: ProjectData, newItem: ProjectData): Boolean {
        return oldItem == newItem
    }
}