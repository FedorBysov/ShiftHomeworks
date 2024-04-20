package com.example.shifthomeworks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shifthomeworks.ListItem
import com.example.shifthomeworks.data
import com.example.shifthomeworks.databinding.PersonCardItemBinding
import com.example.shifthomeworks.databinding.WidjetItemBinding

class CardAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onClickItem: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            CARD_VIEW_TYPE -> CardViewHolder(
                PersonCardItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            WIDGET_VIEW_TYPE -> WidgetViewHolder(
                WidjetItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Wrong viewType: $viewType")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when (holder) {

            is CardViewHolder -> if (item is ListItem.StudentItem) {
                with(holder) {
                    textName.text = "${item.secondName} ${item.name}"
                    description.text = item.description
                    if (item.hasPortfolio) {
                        buttonMore.visibility = View.VISIBLE
                        buttonMore.setOnClickListener {
                            onClickItem?.invoke("More info")
                        }
                    }
                }
            }

            is WidgetViewHolder -> if (item is ListItem.BannerItem) {
                with(holder) {
                    title.text = item.title
                    description.text = item.description
                    acceptBtn.setOnClickListener {
                        onClickItem?.invoke("Accept")
                    }
                    rejectBtn.setOnClickListener {
                        onClickItem?.invoke("Reject")
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (data[position] is ListItem.BannerItem) {
            WIDGET_VIEW_TYPE
        } else {
            CARD_VIEW_TYPE
        }

    override fun getItemCount(): Int = data.size

    companion object {
        const val CARD_VIEW_TYPE = 0
        const val WIDGET_VIEW_TYPE = 1


        const val ENABLED_VIEW = 80
        const val POOL_VIEW_ACTIV = 15

    }

}