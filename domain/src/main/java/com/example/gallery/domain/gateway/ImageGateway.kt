package com.example.gallery.domain.gateway

import com.example.gallery.domain.datamodel.DataList
import io.reactivex.Single
import org.jetbrains.annotations.NotNull

interface ImageGateway {
    fun getNewImages(): Single<DataList>
    fun getPopularImages(): Single<DataList>
}