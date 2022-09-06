package com.example.gallery.domain.usecase

import com.example.gallery.domain.gateway.ImageGateway
import javax.inject.Inject

class ImagesUseCase @Inject constructor(private val imageGateway: ImageGateway) {

    fun getNewImages() = imageGateway.getNewImages()
    fun getPopularImages() = imageGateway.getPopularImages()
}