package hu.ujszaszik.resumeapp.resume.personal.language.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.LanguageRowBinding
import hu.ujszaszik.resumeapp.resume.personal.language.LanguageData

class LanguageViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: LanguageRowBinding

        fun from(parent: ViewGroup): LanguageViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = LanguageRowBinding.inflate(inflater, parent, false)
            return LanguageViewHolder(binding.root)
        }
    }

    fun bind(languageData: LanguageData) {
        binding.languageData = languageData
        binding.executePendingBindings()
    }
}