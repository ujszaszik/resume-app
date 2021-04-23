package hu.ujszaszik.resumeapp.resume.personal.language.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.personal.language.LanguageData

class LanguageItemCallback : DiffUtil.ItemCallback<LanguageData>() {

    override fun areItemsTheSame(oldItem: LanguageData, newItem: LanguageData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: LanguageData, newItem: LanguageData): Boolean {
        return oldItem == newItem
    }
}