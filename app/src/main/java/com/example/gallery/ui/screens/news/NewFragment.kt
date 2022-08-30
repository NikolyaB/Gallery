package com.example.gallery.ui.screens.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.GalleryApp
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.ui.adapter.GalleryAdapter
import com.example.gallery.ui.screens.NewViewModelFactory
import javax.inject.Inject


class NewFragment : Fragment() {

    @Inject
    lateinit var viewMidelFactory: NewViewModelFactory

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GalleryAdapter
    private lateinit var binding: FragmentGalleryBinding

    private lateinit var viewModel: NewViewModel

    override fun onAttach(context: Context) {
        GalleryApp.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, viewMidelFactory)[NewViewModel::class.java]
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
                internetError.visibility = View.VISIBLE
                gallery.visibility = View.GONE
            } else {
                viewModel.resultLive.observe(viewLifecycleOwner) { imageList ->
                    //todo("переписать на isVisible")
                    internetError.isVisible = false
                    gallery.visibility = View.VISIBLE
                    adapter = GalleryAdapter(requireActivity(), imageList = imageList)
                    recyclerView.adapter = adapter
                }
            }
        }
    }


    //todo("naming")
    private fun refreshApp() = binding.run {
        swipeToRefresh.setOnRefreshListener {
            viewModel.getData()
            recyclerViewShow()
            swipeToRefresh.isRefreshing = false
        }
    }
}