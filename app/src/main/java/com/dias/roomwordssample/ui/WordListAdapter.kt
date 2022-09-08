package com.dias.roomwordssample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dias.roomwordssample.R
import com.dias.roomwordssample.data.Word

class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WordsComparator()) {

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val wordItemView: TextView = view.findViewById(R.id.textView)

        fun bind(word: Word) {
            wordItemView.text = word.word
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                return WordViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordViewHolder.create(parent)

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WordsComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }

    }
}