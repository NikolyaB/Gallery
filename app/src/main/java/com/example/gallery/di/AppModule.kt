package com.example.gallery.di

import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.NewViewModelFactory
import com.example.gallery.ui.screens.PopularViewModelFactory
import com.example.gallery.ui.screens.populars.PopularFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideNewViewModelFactory(imagesUseCase: ImagesUseCase): NewViewModelFactory {
        return NewViewModelFactory(imagesUseCase = imagesUseCase)
    }

    @Provides
    fun providePopularViewModelFactory(imagesUseCase: ImagesUseCase): PopularViewModelFactory {
        return PopularViewModelFactory(imagesUseCase = imagesUseCase)
    }
}