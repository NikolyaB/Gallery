package com.example.gallery

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GalleryApi {
    @GET("photos?")
    @Headers("ContentType: application/json")
    fun getDataList(
        @Query(value="new")
        new: Boolean
    ): Single<DataListResponse>
}