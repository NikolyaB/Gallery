package com.example.gallery.domain.gateway

import com.example.gallery.domain.datamodel.DataList
import com.example.gallery.domain.datamodel.ListDataItems
import io.reactivex.Single

interface ImageGateway {
    fun getNewImages(): Single<DataList>
    fun getPopularImages(): Single<DataList>
}