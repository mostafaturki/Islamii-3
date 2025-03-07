package com.route.islamii3.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.route.islamii3.databinding.ItemHadithBinding
import com.route.islamii3.home.fragments.hadith.Hadith

class HadithRecyclerAdapter (private val hadithList: List<Hadith>)
    : Adapter<HadithRecyclerAdapter.HadithViewHolder>(){

        var onHadithClickListener:OnHadithClickListener? = null

    class HadithViewHolder (val binding: ItemHadithBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {

        return HadithViewHolder(ItemHadithBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()= hadithList.size


    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
        val item  = hadithList[position]
        holder.binding.tvHadith.text = item.title
        onHadithClickListener?.let { listener->
            holder.binding.root.setOnClickListener {
                listener.onItemClicked(item,position)
            }
        }
    }

    fun interface OnHadithClickListener{
        fun onItemClicked(hadith: Hadith, position: Int)

    }
}