package com.route.islamii3.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islamii3.databinding.ItemChapterBinding
import com.route.islamii3.home.constants.Constants
import com.route.islamii3.home.fragments.quran.Chapter
import com.route.islamii3.home.fragments.quran.QuranFragment

class ChapterRecyclerAdapter (private val chapters : List<String>)
    : Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    class ViewHolder (val binding: ItemChapterBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(binding = ItemChapterBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvChapterName.text = Constants.chaptersTitles[position]
        holder.binding.tvChapterPosition.text = "${position+1}"
    }

    fun interface OnItemClickListener {
        fun onItemClick(title : String, position: Int)
    }
}