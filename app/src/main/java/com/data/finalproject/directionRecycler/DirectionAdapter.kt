package com.data.finalproject.directionRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.data.finalproject.basic.DirectionFragment
import com.data.finalproject.databinding.DirectionlayoutBinding

class DirectionAdapter (private val direction: List<DirectionDataClass>, private val itemClickListener: DirectionFragment): RecyclerView.Adapter<DirectionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DirectionlayoutBinding.inflate(inflater,parent, false)
        return DirectionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return direction.size
    }

    override fun onBindViewHolder(holder: DirectionViewHolder, position: Int) {
        val item3 = direction[position]
        holder.bind(item3)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(item3, position)
        }
    }

}

