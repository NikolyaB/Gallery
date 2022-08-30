package com.example.gallery.di

import com.example.gallery.data.gateway.DataImageGatewayImpl
import com.example.gallery.domain.gateway.ImageGateway
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun provideDataImageGateway(dataImageGatewayImpl: DataImageGatewayImpl): ImageGateway
}