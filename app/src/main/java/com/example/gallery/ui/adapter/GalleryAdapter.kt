package com.example.gallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.R
import com.example.gallery.domain.datamodel.ListDataItems


//TODO("ListAdapter and DiffUtils")
class GalleryAdapter(private val context: Context, private val imageList: List<ListDataItems>) :
    RecyclerView.Adapter<GalleryAdapter.NewHolder>() {

    override fun getItemCount(): Int = imageList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent, false
        )
        return NewHolder(view)
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
        //todo("вынести в отдельный метод bind у view holder")
        val images = imageList[position]
        Glide.with(context)
            .load(ApiURL + images.image.name)
            .into(holder.imageNew)

        holder.itemView.setOnClickListener {
            //todo("никакиой наыигации из адпатера, только навигация через колбек во фрагмент.")
//            val directions = NewFragmentDirections.actionNavigationImagesToInfoFragment(images)
//            it.findNavController().navigate(directions)
        }
    }

    //todo(вынести в отдельный файл)
    class NewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageNew: ImageView = view.findViewById(R.id.ivPhoto)
    }

    companion object {
        //todo("вынести в константы")
        private const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"
    }
}