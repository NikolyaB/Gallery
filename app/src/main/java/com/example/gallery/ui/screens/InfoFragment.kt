package com.example.gallery.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.gallery.R


class InfoFragment : Fragment() {

    private val args: InfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val iInfo = view.findViewById<ImageView>(R.id.imageInfo)
        var iTitle = view.findViewById<TextView>(R.id.titleInfo)
        var iDescription = view.findViewById<TextView>(R.id.descriptionInfo)
        iTitle.text = args.title
        iDescription.text = args.description

        Glide.with(this)
            .load(ApiURL + args.imageUrl)
            .into(iInfo)
    }


    companion object {
        private const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"
    }

}