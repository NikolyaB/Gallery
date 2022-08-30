package com.example.gallery.di

import com.example.gallery.domain.gateway.ImageGateway
import com.example.gallery.domain.usecase.ImagesUseCase
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    //todo("пределать на binds")
    @Provides
    fun provideGetDataImageListUseCase(
        dataImageGateway: ImageGateway
    ): ImagesUseCase{
        return ImagesUseCase(dataImageGateway = dataImageGateway)
    }

    @Provides
    fun provideGetDataImageListPopularUseCase(
        dataImageGateway: ImageGateway
    ): GetDataImageListPopularUseCase{
        return GetDataImageListPopularUseCase(dataImageGateway = dataImageGateway)
    }

}