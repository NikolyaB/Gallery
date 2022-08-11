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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@SuppressLint("StaticFieldLeak")
private lateinit var adapter: NewAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var imageData: ArrayList<New>
const val ApiURL: String = "https://gallery.prod1.webant.ru/media/"


class NewFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchDataList((activity?.application as? GalleryApp)?.galleryApi)
        imageData = arrayListOf()
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = requireView().findViewById(R.id.rView)
        recyclerView.layoutManager = layoutManager
    }


    private val compositeDisposable = CompositeDisposable()
    fun fetchDataList(galleryApi: GalleryApi?) {
        galleryApi?.let {
            compositeDisposable.add(galleryApi.getDataList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    response.data.forEach{
                        imageData.add(New(imageURL = ApiURL + it.image.name,
                            title = it.title, description = it.description))
                    }
                    adapter = NewAdapter(requireActivity(), imageData)
                    Log.d("TAG", imageData.toString())
                    recyclerView.adapter = adapter
                }, {
                }))
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