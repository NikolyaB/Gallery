package com.example.gallery

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
@SuppressLint("StaticFieldLeak")
private lateinit var adapter: GalleryAdapter
private lateinit var imageData: ArrayList<Image>
private const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"
@SuppressLint("StaticFieldLeak")
private lateinit var binding: FragmentGalleryBinding

class NewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageData = arrayListOf()
        fetchDataList((activity?.application as? GalleryApp)?.galleryApi)
        refreshApp()
    }

    private val compositeDisposable = CompositeDisposable()
    private fun fetchDataList(galleryApi: GalleryApi?) {
        galleryApi?.let {
            compositeDisposable.add(galleryApi.getDataList(true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    response.data.forEach{
                        imageData.add(Image(imageURL = ApiURL + it.image.name,
                                            title = it.title, description = it.description))
                    }
                    val layoutManager = GridLayoutManager(context, 2)
                    recyclerView = binding.rView
                    recyclerView.layoutManager = layoutManager
                    adapter = GalleryAdapter(requireActivity(), imageData)
                    recyclerView.adapter = adapter
                    binding.rView.visibility = View.VISIBLE
                    binding.imageNotInternet.visibility = View.GONE
                    binding.textFirstNotInternet.visibility = View.GONE
                    binding.textLastNotInternet.visibility = View.GONE
                }, {
                    binding.rView.visibility = View.GONE
                    binding.imageNotInternet.visibility = View.VISIBLE
                    binding.textFirstNotInternet.visibility = View.VISIBLE
                    binding.textLastNotInternet.visibility = View.VISIBLE
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



//    private fun dataInitialize(){
//        newArrayList = arrayListOf<New>()
//
//        imageId = arrayOf(
//            R.drawable.bitmap1,
//            R.drawable.bitmap2,
//            R.drawable.bitmap3,
//            R.drawable.bitmap4,
//            R.drawable.bitmap5,
//            R.drawable.bitmap6,
//            R.drawable.bitmap7,
//            R.drawable.bitmap8,
//        )
//
//        for (i in imageId.indices){
//            val new = New(imageId[i])
//            newArrayList.add(new)
//        }

}