package hu.ujszaszik.resumeapp.resume.personal.language.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.personal.language.LanguageData

class LanguageAdapter : ListAdapter<LanguageData, LanguageViewHolder>(LanguageItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}