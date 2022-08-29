package com.example.gallery.data.storage.network

import com.example.gallery.data.storage.models.DataListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GalleryApi {
    @GET("photos")
    @Headers("ContentType: application/json")
    fun getDataImageList(
        @Query(value="new")
        new: Boolean = false,
        @Query(value="popular")
        popular: Boolean = false
    ): Single<DataListResponse>
}