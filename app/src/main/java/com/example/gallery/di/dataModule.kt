package com.example.gallery.di

import com.example.gallery.data.gateway.ImageGatewayImpl
import com.example.gallery.domain.gateway.ImageGateway
import org.koin.dsl.module

val dataModule = module {
    single<ImageGateway> {
        ImageGatewayImpl(galleryApi = get())
    }
}
