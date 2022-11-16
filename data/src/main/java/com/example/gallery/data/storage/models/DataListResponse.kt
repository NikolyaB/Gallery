package com.example.gallery.data.storage.models

import com.google.gson.annotations.SerializedName

data class DataListResponse (
    @SerializedName("data")
    val data: List<ListDataItems>?
)

data class ListDataItems(
    @SerializedName("image")
    val image: ImageItem?,
    @SerializedName("name")
    val title: String?,
    @SerializedName("description")
    val description: String?
)


data class ImageItem (
    @SerializedName("name")
    val name: String
)
