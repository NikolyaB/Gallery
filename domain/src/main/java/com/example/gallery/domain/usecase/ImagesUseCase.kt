package com.example.gallery.domain.usecase

import com.example.gallery.domain.datamodel.DataList
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.domain.gateway.ImageGateway

class ImagesUseCase constructor(private val imageGateway: ImageGateway) {
    fun getNewImages() = imageGateway.getNewImages()
    fun getPopularImages() = imageGateway.getPopularImages()
}