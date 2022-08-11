package com.example.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.databinding.ListItemNewBinding

class NewAdapter(private val context: Context, private val newList: ArrayList<New>) : RecyclerView.Adapter<NewAdapter.NewHolder>() {

    class NewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ListItemNewBinding.bind(view)
//        fun bind(new: New) = with(binding){
//            im.setImageResource(new.imageURL)
//        }
        var imageNew: ImageView = view.findViewById(R.id.im)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new,
            parent, false)
        return NewHolder(view)
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
        val news = newList[position]
//        holder.bind(newList[position])
        Glide.with(context)
            .load(news.imageURL)
            .into(holder.imageNew)

        holder.itemView.setOnClickListener{
            val directions = NewFragmentDirections.actionNavigationNewToInfoFragment(news)
            it.findNavController().navigate(directions)
        }
    }

    override fun getItemCount(): Int = newList.size
}