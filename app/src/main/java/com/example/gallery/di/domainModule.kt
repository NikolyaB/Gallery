package com.example.gallery.di

import com.example.gallery.domain.usecase.ImagesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<ImagesUseCase> {
       ImagesUseCase(imageGateway = get())
    }
}