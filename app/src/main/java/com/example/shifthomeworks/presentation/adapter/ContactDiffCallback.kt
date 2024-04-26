package com.example.shifthomeworks.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shifthomeworks.domain.model.ContactItem

class ContactDiffCallback : DiffUtil.ItemCallback<ContactItem>() {
    override fun areItemsTheSame(oldItem: ContactItem, newItem: ContactItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ContactItem, newItem: ContactItem): Boolean {
        return oldItem == newItem
    }

}