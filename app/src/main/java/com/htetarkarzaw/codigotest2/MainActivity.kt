package com.htetarkarzaw.codigotest2

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.htetarkarzaw.codigotest2.common.base.BaseActivity
import com.htetarkarzaw.codigotest2.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var roomAdapter: RoomAdapter
    private lateinit var rateAdapter: RateAdapter
    override fun initUi() {
        setupImageRecyclerViews()
        setupToggleRecyclerViews(1)
        binding.tvByRoom.setOnClickListener {
            setupToggleRecyclerViews(1)
        }
        binding.tvByRates.setOnClickListener {
            setupToggleRecyclerViews(0)
        }
    }

    private fun setupToggleRecyclerViews(number: Int) {
        if (number == 1) {
            binding.rvRoom.visibility = View.VISIBLE
            binding.rvRates.visibility = View.GONE
            binding.tvByRoom.setBackgroundResource(R.drawable.bg_tab_layout_selected)
            binding.tvByRates.setBackgroundResource(R.drawable.bg_tab_layout_unselected)
        } else {
            binding.rvRates.visibility = View.VISIBLE
            binding.rvRoom.visibility = View.GONE
            binding.tvByRates.setBackgroundResource(R.drawable.bg_tab_layout_selected)
            binding.tvByRoom.setBackgroundResource(R.drawable.bg_tab_layout_unselected)
        }
    }

    private fun setupImageRecyclerViews() {
        val list = resources.getStringArray(R.array.imgList).toMutableList()
        imageAdapter = ImageAdapter().apply {
            binding.rvImage.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false
            )
            binding.rvImage.adapter = this
        }
        imageAdapter.submitList(list)
        roomAdapter = RoomAdapter().apply {
            binding.rvRoom.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            binding.rvRoom.adapter = this
        }
        roomAdapter.submitList(list)
        rateAdapter = RateAdapter().apply {
            binding.rvRates.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL, false
            )
            binding.rvRates.adapter = this
        }
        rateAdapter.submitList(list)
    }

    override fun observe() {
    }
}