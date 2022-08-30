package com.example.gallery.di

import android.content.Context
import com.example.gallery.domain.usecase.GetDataImageListNewUseCase
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase
import com.example.gallery.ui.screens.NewViewModelFactory
import com.example.gallery.ui.screens.PopularViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule() {

    @Provides
    fun provideNewViewModelFactory(
        getDataImageListNewUseCase: GetDataImageListNewUseCase
    ) : NewViewModelFactory {
        return NewViewModelFactory(getDataImageListNewUseCase = getDataImageListNewUseCase)
    }

    @Provides
    fun providePopularViewModelFactory(
        getDataImageListPopularUseCase: GetDataImageListPopularUseCase
    ) : PopularViewModelFactory {
        return PopularViewModelFactory(getDataImageListPopularUseCase = getDataImageListPopularUseCase)
    }


}