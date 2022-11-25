package com.example.gallery.data.storage.network

import com.example.gallery.data.storage.models.DataListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow

class GalleryServiceImpl(
    private val client: HttpClient
): GalleryService {
    override suspend fun getDataImageList(value: String) = client
        .get { url(HttpRoutes.GET); parameter(value, true)}
        .body<DataListResponse>()
}