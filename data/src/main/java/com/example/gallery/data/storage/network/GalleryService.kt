package com.example.gallery.data.storage.network

import com.example.gallery.data.storage.models.DataListResponse
import kotlinx.coroutines.flow.Flow

interface GalleryService {
    suspend fun getDataImageList(value: String): DataListResponse
}