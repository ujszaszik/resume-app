package hu.ujszaszik.resumeapp.resume.personal.quotes.adapter

import androidx.recyclerview.widget.DiffUtil
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData

class QuoteItemCallback : DiffUtil.ItemCallback<QuoteData>() {

    override fun areItemsTheSame(oldItem: QuoteData, newItem: QuoteData): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: QuoteData, newItem: QuoteData): Boolean {
        return oldItem == newItem
    }
}