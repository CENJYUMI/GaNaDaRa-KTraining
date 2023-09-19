package com.data.finalproject.unitRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.data.finalproject.basic.UnitsFragment
import com.data.finalproject.databinding.UnitLayoutBinding

class UnitsAdapter(private val units: List<UnitsData>, private val itemClickListener: UnitsFragment): RecyclerView.Adapter<UnitsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnitsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UnitLayoutBinding.inflate(inflater,parent,false)
        return UnitsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return units.size
    }

    override fun onBindViewHolder(holder: UnitsViewHolder, position: Int) {
        val item2 = units[position]
        holder.bind(item2)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item2,position)
        }
    }

}



