package com.example.gallery.data.storage.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataListResponse (
    val data: List<ListDataItemsResponse>?
)

@Serializable
data class ListDataItemsResponse(
    val image: ImageItem?,
    @SerialName("name")
    val title: String?,
    val description: String?
)

@Serializable
data class ImageItem (
    val name: String?
)
