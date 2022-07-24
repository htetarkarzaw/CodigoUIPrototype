package com.htetarkarzaw.codigotest2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.htetarkarzaw.codigotest2.databinding.ViewHolderRateBinding

class RateAdapter :
    ListAdapter<String, RecyclerView.ViewHolder>(newDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ViewHolderRateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RateViewHolder).bind(getItem(position))
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

    inner class RateViewHolder(private val binding: ViewHolderRateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String?) {

        }
    }
}