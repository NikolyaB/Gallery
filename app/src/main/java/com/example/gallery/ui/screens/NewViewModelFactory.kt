package com.example.gallery.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.news.NewViewModel

class NewViewModelFactory (
    val imagesUseCase: ImagesUseCase
): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return NewViewModel(
            imagesUseCase = imagesUseCase
        ) as T
    }
}