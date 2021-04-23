package hu.ujszaszik.resumeapp.resume.projects.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.projects.ProjectData

class ProjectsAdapter : ListAdapter<ProjectData, ProjectsViewHolder>(ProjectsItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        return ProjectsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}