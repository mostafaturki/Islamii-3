package com.route.islamii3.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.islamii3.databinding.ItemChapterBinding
import com.route.islamii3.home.constants.Constants
import com.route.islamii3.home.fragments.quran.Chapter
import com.route.islamii3.home.fragments.quran.QuranFragment

class ChapterRecyclerAdapter (private val chapters : List<Chapter>)
    : Adapter<ChapterRecyclerAdapter.ViewHolder>() {

         var onItemClickListener: OnItemClickListener? = null

    class ViewHolder (val binding: ItemChapterBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(binding = ItemChapterBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = chapters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = chapters.get(position)
        holder.binding.tvChapterName.text = item.title
        holder.binding.tvChapterPosition.text = item.position.toString()
//        val title = holder.binding.tvChapterName
//            title.text = Constants.chaptersTitles[position]
//         val position= holder.binding.tvChapterPosition
//             position = position+1

        onItemClickListener?.let { listener ->
            holder.binding.root.setOnClickListener {
                listener.onItemClick(item,position)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(chapter : Chapter, position: Int)
    }
}