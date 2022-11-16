package com.example.gallery.domain.datamodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListDataItems(
    val image: ImageItem?,
    val title: String?,
    val description: String?
): Parcelable

@Parcelize
data class ImageItem(
    val name: String?
): Parcelable
