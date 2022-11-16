package com.example.gallery.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.DataList
import io.reactivex.disposables.CompositeDisposable


abstract class BaseGalleryViewModel: ViewModel() {
    protected val resultLiveMutable = MutableLiveData<DataList>()
    val resultLive: LiveData<DataList> = resultLiveMutable
    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    open fun getData() {}
}