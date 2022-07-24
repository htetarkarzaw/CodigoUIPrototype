package com.htetarkarzaw.codigotest2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.htetarkarzaw.codigotest2.databinding.ViewHolderImageBinding

class ImageAdapter :
    ListAdapter<String, RecyclerView.ViewHolder>(newDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ViewHolderImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LanguageViewHolder).bind(getItem(position))
    }

    companion object {
        val newDiffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class LanguageViewHolder(private val binding: ViewHolderImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String?) {
            Glide.with(itemView.context)
                .load(item)
                .placeholder(R.drawable.place_holder)
                .into(binding.ivImage)
        }
    }
}