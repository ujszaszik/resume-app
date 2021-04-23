package hu.ujszaszik.resumeapp.resume.personal.quotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ujszaszik.resumeapp.databinding.QuoteRowBinding
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData

class QuoteViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        private lateinit var binding: QuoteRowBinding

        fun from(parent: ViewGroup): QuoteViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            binding = QuoteRowBinding.inflate(inflater, parent, false)
            return QuoteViewHolder(binding.root)
        }
    }

    fun bind(quoteData: QuoteData) {
        binding.quoteData = quoteData
        binding.executePendingBindings()
    }
}