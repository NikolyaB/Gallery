package com.example.gallery.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.ui.model.DataList
import com.example.gallery.ui.model.ListDataItems
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase
import com.example.gallery.ui.model.ImageItem
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularViewModel(
    private val getDataImageListPopularUseCase: GetDataImageListPopularUseCase
): ViewModel() {
    private var resultLiveMutable = MutableLiveData<List<ListDataItems>>()
    val resultLive: MutableLiveData<List<ListDataItems>> = resultLiveMutable
    private var internetErrorLive = MutableLiveData<Boolean>()
    val internetError: MutableLiveData<Boolean> = internetErrorLive
    private val compositeDisposable = CompositeDisposable()

    init {
        getData()
    }

    fun getData() {
        val dataImage = getDataImageListPopularUseCase.execute()
        compositeDisposable.add(dataImage
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                DataList(it.data.map { dataListItems ->
                    with(dataListItems) {
                        ListDataItems(
                            ImageItem(image.name),
                            title,
                            description
                        )
                    }
                })
            }
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