package com.example.gallery.domain.gateway

import com.example.gallery.domain.datamodel.DataList
import kotlinx.coroutines.flow.Flow

interface ImageGateway {
    suspend fun getNewImages(): DataList
    suspend fun getPopularImages(): DataList
}