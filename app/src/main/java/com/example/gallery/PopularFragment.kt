package com.example.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.databinding.FragmentGalleryBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@SuppressLint("StaticFieldLeak")
private lateinit var recyclerView: RecyclerView
private lateinit var imageData: ArrayList<Image>
private const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"
private lateinit var binding: FragmentGalleryBinding

class PopularFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context, 2)
        imageData = arrayListOf()
        recyclerView = binding.rView
        recyclerView.layoutManager = layoutManager
        fetchDataList((activity?.application as? GalleryApp)?.galleryApi)
        refreshApp()
    }


    private val compositeDisposable = CompositeDisposable()
    private fun fetchDataList(galleryApi: GalleryApi?) {
        galleryApi?.let {
            compositeDisposable.add(galleryApi.getDataList(false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    response.data.forEach{
                        imageData.add(Image(imageURL = ApiURL + it.image.name,
                            title = it.title, description = it.description))
                    }
                    recyclerView.adapter = GalleryAdapter(requireActivity(), imageData)
                }, {
                }))
        }
    }

    private fun refreshApp() {
        binding.run {
            swipeToRefresh.setOnRefreshListener {
                fetchDataList((activity?.application as? GalleryApp)?.galleryApi)
                swipeToRefresh.isRefreshing = false
            }
        }
    }
}