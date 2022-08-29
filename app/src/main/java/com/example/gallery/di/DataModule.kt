package com.example.gallery.di

import com.example.gallery.data.gateway.DataImageGatewayImpl
import com.example.gallery.data.storage.network.GalleryApi
import com.example.gallery.domain.gateway.DataImageGateway
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideDataImageGateway(galleryApi: GalleryApi): DataImageGateway {
        return DataImageGatewayImpl(galleryApi = galleryApi)
    }
}