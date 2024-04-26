package com.example.shifthomeworks.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shifthomeworks.databinding.ItemCardBinding

class ContactViewHolder (binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.textName
    val number = binding.textNumber
}