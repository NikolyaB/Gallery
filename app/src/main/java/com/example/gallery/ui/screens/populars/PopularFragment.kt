package com.example.gallery.ui.screens.populars

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.GalleryApp
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.ui.adapter.GalleryAdapter
import com.example.gallery.ui.screens.PopularViewModelFactory
import javax.inject.Inject


class PopularFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: PopularViewModelFactory

    private lateinit var viewModel: PopularViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GalleryAdapter
    private lateinit var binding: FragmentGalleryBinding

    override fun onAttach(context: Context) {
        GalleryApp.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, viewModelFactory)[PopularViewModel::class.java]
        recyclerViewShow()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshApp()
    }

    private fun recyclerViewShow() = with(binding) {
        recyclerView = rView
        viewModel.internetError.observe(viewLifecycleOwner) {
            if (it == true) {
                internetError.isVisible = true
                gallery.isVisible = false
            } else {
                viewModel.resultLive.observe(viewLifecycleOwner) { imageList ->
                    //todo("переписать на isVisible")
                    internetError.isVisible = false
                    gallery.isVisible = true
                    adapter = GalleryAdapter(imageList = imageList) { it: ListDataItems ->
                        val directions = PopularFragmentDirections.actionPopularFragmentToInfoFragment(
                            imageName = it.image.name, title = it.title, description = it.description)
                        root.findNavController().navigate(directions)
                    }
                    recyclerView.adapter = adapter
                }
            }
        }
    }


    private fun refreshApp() {
        binding.run {
            swipeToRefresh.setOnRefreshListener {
                viewModel.getData()
                recyclerViewShow()
                swipeToRefresh.isRefreshing = false
            }
        }
    }
}