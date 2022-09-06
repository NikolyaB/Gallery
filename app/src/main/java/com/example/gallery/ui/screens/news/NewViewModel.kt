package com.example.gallery.ui.screens.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.domain.usecase.ImagesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewViewModel(
    private val imagesUseCase: ImagesUseCase
) : ViewModel() {
    private val resultLiveMutable = MutableLiveData<List<ListDataItems>>()
    val resultLive: LiveData<List<ListDataItems>> = resultLiveMutable
    private val internetErrorLive = MutableLiveData<Boolean>()
    val internetError: LiveData<Boolean> = internetErrorLive
    private val compositeDisposable = CompositeDisposable()

    init {
        getData()
    }

    fun getData() {
        //todo("исправить")
        imagesUseCase.getNewImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    resultLiveMutable.postValue(it.data)
                    internetErrorLive.value = false
                }, {
                    internetErrorLive.value = true
                }
            ).let(compositeDisposable::add)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}