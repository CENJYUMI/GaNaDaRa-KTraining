package com.data.finalproject.DirectionRecycler

import androidx.recyclerview.widget.RecyclerView
import com.data.finalproject.databinding.DirectionlayoutBinding

class DirectionViewHolder (private var binding: DirectionlayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: DirectionDataClass){
        binding.korean.text = item.koreanDirection
        binding.directionMeaning.text = item.englishDirecton
        binding.example.text = item.exampleDirection
    }
}

