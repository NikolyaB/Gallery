package com.example.gallery.domain.usecase

import com.example.gallery.domain.gateway.ImageGateway

class ImagesUseCase(private val imageGateway: ImageGateway) {

    fun getNewImages() = imageGateway.getNewImages()

    fun getPopularImages() = imageGateway.getPopularImages()
}