package com.example.gallery.ui.screens.populars

import android.content.Context
import androidx.navigation.fragment.findNavController
import com.example.gallery.GalleryApp
import com.example.gallery.ui.adapter.GalleryAdapter
import com.example.gallery.ui.screens.BaseGalleryFragment


class PopularFragment : BaseGalleryFragment<PopularViewModel>() {
    override fun onAttach(context: Context) {
        GalleryApp.appComponent.inject(this)
        super.onAttach(context)
    }
    override fun getViewModelClass() = PopularViewModel::class.java

    override fun setUpViews() {
        super.setUpViews()
        recyclerView = binding.rView
        viewModel.resultLive.observe(viewLifecycleOwner) { imageList ->
            adapter = GalleryAdapter(imageList = imageList) {
                val directions = PopularFragmentDirections.actionPopularFragmentToInfoFragment(
                    imageName = it.image.name, title = it.title, description = it.description)
                findNavController().navigate(directions)
            }
            recyclerView.adapter = adapter
        }
    }
}