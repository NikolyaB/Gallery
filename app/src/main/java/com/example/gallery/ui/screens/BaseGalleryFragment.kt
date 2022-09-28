package com.example.gallery.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.FragmentGalleryBinding
import com.example.gallery.ui.adapter.GalleryAdapter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseGalleryFragment<ViewModel: BaseGalleryViewModel>: Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GalleryAdapter

    @Inject
    lateinit var viewModelFactory: BaseGalleryViewModelFactory

    protected lateinit var viewModel: ViewModel
    protected abstract fun getViewModelClass(): Class<ViewModel>

    protected lateinit var binding: FragmentGalleryBinding

    private val disposableContainer = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        refreshRecycler()
    }

    open fun setUpViews() {}

    private fun refreshRecycler() = binding.run {
        swipeToRefresh.setOnRefreshListener {
            viewModel.getData()
            swipeToRefresh.isRefreshing = false
        }
    }

    fun Disposable.addToContainer() = disposableContainer.add(this)

    override fun onDestroyView() {
        disposableContainer.clear()
        super.onDestroyView()
    }
}