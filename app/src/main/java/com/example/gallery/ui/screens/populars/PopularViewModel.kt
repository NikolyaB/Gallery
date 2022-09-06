package com.example.gallery.ui.screens.populars

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.domain.usecase.ImagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularViewModel(
    private val imagesUseCase: ImagesUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<List<ListDataItems>>()
    val resultLive: MutableLiveData<List<ListDataItems>> = resultLiveMutable
    private var internetErrorLive = MutableLiveData<Boolean>()
    val internetError: MutableLiveData<Boolean> = internetErrorLive
    private val compositeDisposable = CompositeDisposable()


    init {
        getData()
    }


    fun getData() {
        val dataImage = imagesUseCase.getPopularImages()
        compositeDisposable.add(dataImage
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    resultLiveMutable.postValue(it.data)
                    internetErrorLive.value = false
                }, {
                    internetErrorLive.value = true
                }
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}