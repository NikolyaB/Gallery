package com.example.gallery.di

import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase
import com.example.gallery.ui.screens.NewViewModelFactory
import com.example.gallery.ui.screens.PopularViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {

    @Provides
    fun provideNewViewModelFactory(
        getDataImageListNewUseCase: ImagesUseCase
    ): NewViewModelFactory {
        return NewViewModelFactory(getDataImageListNewUseCase = getDataImageListNewUseCase)
    }

    @Provides
    fun providePopularViewModelFactory(
        getDataImageListPopularUseCase: GetDataImageListPopularUseCase
    ): PopularViewModelFactory {
        return PopularViewModelFactory(getDataImageListPopularUseCase = getDataImageListPopularUseCase)
    }


}