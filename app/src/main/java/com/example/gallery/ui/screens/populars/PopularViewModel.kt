package com.example.gallery.ui.screens.populars

import androidx.lifecycle.viewModelScope
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.BaseGalleryViewModel
import kotlinx.coroutines.*

class PopularViewModel(
    private val imagesUseCase: ImagesUseCase
): BaseGalleryViewModel() {
    init {
        getData()
    }

    override fun getData() {
        viewModelScope.launch {
            val response = imagesUseCase.getPopularImages()
            withContext(Dispatchers.IO) {
                    dataImage.value = response
            }
        }
    }
}
