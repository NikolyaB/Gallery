package com.example.gallery.ui.screens.news

import androidx.lifecycle.viewModelScope
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.BaseGalleryViewModel
import kotlinx.coroutines.*

class NewViewModel(
    private val imagesUseCase: ImagesUseCase
): BaseGalleryViewModel() {
    init {
        getData()
    }

    override fun getData() {
        viewModelScope.launch {
            val response = imagesUseCase.getNewImages()
            withContext(Dispatchers.IO) {
                dataImage.value = response
            }
        }
    }
}