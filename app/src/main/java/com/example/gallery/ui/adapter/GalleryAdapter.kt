package com.example.gallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.ui.model.ListDataItems
import com.example.gallery.ui.screens.NewFragmentDirections


class GalleryAdapter(private val context: Context, private val imageList: List<ListDataItems>) : RecyclerView.Adapter<GalleryAdapter.NewHolder>() {

    class NewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imageNew: ImageView = view.findViewById(R.id.im)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent, false)
        return NewHolder(view)
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
        val images = imageList[position]
        Glide.with(context)
            .load(ApiURL + images.image.name)
            .into(holder.imageNew)

        holder.itemView.setOnClickListener{
            val directions = NewFragmentDirections.actionNavigationImagesToInfoFragment(images)
            it.findNavController().navigate(directions)
        }
    }

    override fun getItemCount(): Int = imageList.size

    companion object {
        private const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"
    }
}