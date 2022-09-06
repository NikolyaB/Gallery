package com.example.gallery.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.populars.PopularViewModel

class PopularViewModelFactory (
    val imagesUseCase: ImagesUseCase
): ViewModelProvider.Factory {
        override fun <T: ViewModel> create(modelClass: Class<T>): T {
            return PopularViewModel(
                imagesUseCase = imagesUseCase
            ) as T
        }
    }