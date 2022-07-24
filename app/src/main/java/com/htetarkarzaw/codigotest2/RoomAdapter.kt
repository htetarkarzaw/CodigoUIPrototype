package com.htetarkarzaw.codigotest2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.htetarkarzaw.codigotest2.databinding.ViewHolderRoomItemBinding

class RoomAdapter :
    ListAdapter<String, RecyclerView.ViewHolder>(newDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ViewHolderRoomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RoomViewHolder).bind(getItem(position))
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

    inner class RoomViewHolder(private val binding: ViewHolderRoomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String?) {
            Glide.with(itemView.context)
                .load(item)
                .placeholder(R.drawable.place_holder)
                .into(binding.ivRoomPhoto)
        }
    }
}