package com.example.shifthomeworks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shifthomeworks.databinding.ItemCardBinding
import com.example.shifthomeworks.domain.model.ContactItem

class AdapterContact : ListAdapter<ContactItem, ContactViewHolder>(ContactDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val requestItem = getItem(position)
        with(holder) {

            name.text = requestItem.name
            number.text = requestItem.number

        }
    }

    companion object {
        const val POOL_VIEW_ACTIV = 15
        const val POOL_VIEW_DISABLE = 15
    }

}