package com.example.gallery.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.GalleryApp
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.ui.adapter.GalleryAdapter
import javax.inject.Inject

private lateinit var recyclerView: RecyclerView
@SuppressLint("StaticFieldLeak")
private lateinit var adapter: GalleryAdapter
@SuppressLint("StaticFieldLeak")
private lateinit var binding: FragmentGalleryBinding

class PopularFragment : Fragment() {
    @Inject
    lateinit var vmFactory: PopularViewModelFactory

    private lateinit var vm: PopularViewModel


    override fun onAttach(context: Context) {
        (context.applicationContext as GalleryApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this, vmFactory)[PopularViewModel::class.java]
        recyclerViewShow()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshApp()
    }


    private fun recyclerViewShow() {
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = binding.rView
        recyclerView.layoutManager = layoutManager
        vm.internetError.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.internetError.visibility = View.VISIBLE
                binding.gallery.visibility = View.GONE
            } else {
                vm.resultLive.observe(viewLifecycleOwner) { imageList ->
                    binding.internetError.visibility = View.GONE
                    binding.gallery.visibility = View.VISIBLE
                    adapter = GalleryAdapter(requireActivity(), imageList = imageList)
                    recyclerView.adapter = adapter
                }
            }
        }
    }


    private fun refreshApp() {
        binding.run {
            swipeToRefresh.setOnRefreshListener {
                vm.getData()
                recyclerViewShow()
                swipeToRefresh.isRefreshing = false
            }
        }
    }
}