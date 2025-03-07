package com.route.islamii3.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamii3.databinding.ItemChapterBinding
import com.route.islamii3.databinding.ItemVerseBinding

class VersesAdapter(val versesList : List<String>):Adapter<VersesAdapter.VersesViewHolder>() {

    class VersesViewHolder ( val binding: ItemVerseBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {

        return VersesViewHolder(ItemVerseBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = versesList.size


    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = versesList[position]
        holder.binding.tvChapterContent.text = "$item (${position+1})"
    }
}