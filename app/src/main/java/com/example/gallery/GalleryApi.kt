package com.example.gallery

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface GalleryApi {
    @GET("/api/photos?new=true/")
    @Headers("ContentType: application/json")
    fun getDataList(): Single<DataListResponse>
}