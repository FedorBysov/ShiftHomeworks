package com.example.shifthomeworks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shifthomeworks.databinding.WidjetItemBinding

class WidgetViewHolder(private val binding: WidjetItemBinding) : RecyclerView.ViewHolder(binding.root){

    val title = binding.title
    val description = binding.description
    val acceptBtn = binding.accept
    val rejectBtn = binding.reject

}