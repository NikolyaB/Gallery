package com.example.gallery.di

import com.example.gallery.domain.gateway.DataImageGateway
import com.example.gallery.domain.usecase.GetDataImageListNewUseCase
import com.example.gallery.domain.usecase.GetDataImageListPopularUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetDataImageListUseCase(
        dataImageGateway: DataImageGateway
    ): GetDataImageListNewUseCase{
        return GetDataImageListNewUseCase(dataImageGateway = dataImageGateway)
    }

    @Provides
    fun provideGetDataImageListPopularUseCase(
        dataImageGateway: DataImageGateway
    ): GetDataImageListPopularUseCase{
        return GetDataImageListPopularUseCase(dataImageGateway = dataImageGateway)
    }

}