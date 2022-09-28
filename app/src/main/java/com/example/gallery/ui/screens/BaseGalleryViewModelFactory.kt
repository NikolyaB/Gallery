package com.example.gallery.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.news.NewViewModel
import com.example.gallery.ui.screens.populars.PopularViewModel

class BaseGalleryViewModelFactory(val imagesUseCase: ImagesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NewViewModel::class.java) -> NewViewModel(imagesUseCase = imagesUseCase) as T
            modelClass.isAssignableFrom(PopularViewModel::class.java) -> PopularViewModel(imagesUseCase = imagesUseCase) as T
            else -> throw IllegalAccessException("ViewModel Not Found")
        }
    }
}