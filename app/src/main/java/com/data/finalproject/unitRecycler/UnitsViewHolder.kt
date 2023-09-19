package com.data.finalproject.unitRecycler

import androidx.recyclerview.widget.RecyclerView
import com.data.finalproject.databinding.UnitLayoutBinding

class UnitsViewHolder (private var binding: UnitLayoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(item: UnitsData){
        binding.unitname.text = item.unitName
        binding.unitmeaning.text = item.unitMeaning
        binding.whereToUseKorean.text = item.whereToUseKorean
        binding.whereToUseEnglish.text = item.whereToUseEnglish
    }
}

