package com.example.gallery.ui.screens.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.BaseGalleryViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewViewModel(
    private val imagesUseCase: ImagesUseCase
) : BaseGalleryViewModel() {

    init {
        getData()
    }

    override fun getData() {
        imagesUseCase.getNewImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    resultLiveMutable.postValue(it.data)
                }, { }
            ).let(compositeDisposable::add)
    }
}