package com.example.gallery.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase

class PopularViewModelFactory (
    val getDataImageListPopularUseCase: GetDataImageListPopularUseCase
    ): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return PopularViewModel(
            getDataImageListPopularUseCase = getDataImageListPopularUseCase
        ) as T
    }
}