package com.example.gallery.ui.screens.populars

import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.BaseGalleryViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularViewModel(
    private val imagesUseCase: ImagesUseCase
): BaseGalleryViewModel() {

    init {
        getData()
    }

    override fun getData() {
        imagesUseCase.getPopularImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    resultLiveMutable.postValue(it)
                }, { }
            ).let(compositeDisposable::add)
    }
}