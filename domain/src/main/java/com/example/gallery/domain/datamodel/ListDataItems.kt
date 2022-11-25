package com.example.gallery.domain.datamodel

data class ListDataItems(
    val image: ImageItem?,
    val title: String?,
    val description: String?
)

data class ImageItem(
    val name: String?
)