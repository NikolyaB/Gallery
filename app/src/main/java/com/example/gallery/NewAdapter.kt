package com.example.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.ListItemNewBinding

class NewAdapter(private val newList: ArrayList<New>) : RecyclerView.Adapter<NewAdapter.NewHolder>() {

    class NewHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ListItemNewBinding.bind(item)
        fun bind(new: New) = with(binding){
            im.setImageResource(new.imageID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new,
            parent, false)
        return NewHolder(view)
    }

    override fun onBindViewHolder(holder: NewHolder, position: Int) {
        holder.bind(newList[position])
    }

    override fun getItemCount(): Int {
        return newList.size
    }

}