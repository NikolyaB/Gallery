package com.example.gallery.di

import com.example.gallery.data.gateway.ImageGatewayImpl
import com.example.gallery.data.storage.network.GalleryService
import com.example.gallery.data.storage.network.GalleryServiceImpl
import com.example.gallery.domain.gateway.ImageGateway
import org.koin.dsl.module

val dataModule = module {

    single<GalleryService> {
        GalleryServiceImpl(get())
    }

    single {
        GalleryServiceImpl(get())
    }

    single<ImageGateway> {
        ImageGatewayImpl(galleryServiceImpl = get())
    }
}
