package com.example.shifthomeworks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shifthomeworks.databinding.PersonCardItemBinding

class CardViewHolder(private val binding: PersonCardItemBinding) : RecyclerView.ViewHolder(binding.root){

    val textName = binding.name
    val description = binding.description
    val buttonMore = binding.buttonMore

}