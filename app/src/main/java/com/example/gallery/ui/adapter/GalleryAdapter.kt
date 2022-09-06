package com.example.gallery.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.ListItemBinding
import com.example.gallery.domain.datamodel.ListDataItems


//TODO("ListAdapter and DiffUtils")
class GalleryAdapter(private var imageList: List<ListDataItems>,
                     private var onItemClicked: ((imageList: ListDataItems) -> Unit)) :
    RecyclerView.Adapter<ImageHolder>() {

    override fun getItemCount(): Int = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        //todo("вынести в отдельный метод bind у view holder")
        val images = imageList[position]
        holder.bind(images, onItemClicked)
    }

    //todo(вынести в отдельный файл)

}