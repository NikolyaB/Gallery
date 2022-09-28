package com.example.gallery.di

import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.ui.screens.BaseGalleryViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {
    @Provides
    fun provideGalleryViewModelFactory(imagesUseCase: ImagesUseCase): BaseGalleryViewModelFactory {
        return BaseGalleryViewModelFactory(imagesUseCase = imagesUseCase)
    }
}