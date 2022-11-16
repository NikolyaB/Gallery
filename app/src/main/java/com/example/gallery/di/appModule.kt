package com.example.gallery.di

import com.example.gallery.ui.screens.BaseGalleryViewModel
import com.example.gallery.ui.screens.news.NewViewModel
import com.example.gallery.ui.screens.populars.PopularViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<NewViewModel> {
        NewViewModel(imagesUseCase = get())
    }
    viewModel<PopularViewModel>{
        PopularViewModel(imagesUseCase = get ())
    }
}