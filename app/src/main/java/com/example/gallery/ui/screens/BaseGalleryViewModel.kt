package com.example.gallery.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.ListDataItems
import io.reactivex.disposables.CompositeDisposable

abstract class BaseGalleryViewModel: ViewModel() {
    protected val resultLiveMutable = MutableLiveData<List<ListDataItems>>()
    val resultLive: LiveData<List<ListDataItems>> = resultLiveMutable
    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
    open fun getData() {}
}