package com.example.gallery.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.Constants
import com.example.gallery.databinding.ListItemBinding
import com.example.gallery.domain.datamodel.ListDataItems

class ImageHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(listDataItems: ListDataItems,
             onItemClicked: (imageList: ListDataItems) -> Unit) = binding.apply {
        Glide.with(root)
            .load(Constants.API_URL + listDataItems.image.name)
            .into(ivPhoto)

        root.setOnClickListener {
            onItemClicked(listDataItems)
        }
    }
}