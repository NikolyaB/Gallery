package com.example.gallery.domain.usecase

import com.example.gallery.domain.gateway.ImageGateway

class ImagesUseCase constructor(private val imageGateway: ImageGateway) {
    suspend fun getNewImages() = imageGateway.getNewImages()
    suspend fun getPopularImages() = imageGateway.getPopularImages()
}