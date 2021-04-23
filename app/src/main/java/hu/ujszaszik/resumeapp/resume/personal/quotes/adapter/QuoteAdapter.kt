package hu.ujszaszik.resumeapp.resume.personal.quotes.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import hu.ujszaszik.resumeapp.resume.personal.quotes.QuoteData

class QuoteAdapter : ListAdapter<QuoteData, QuoteViewHolder>(QuoteItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}