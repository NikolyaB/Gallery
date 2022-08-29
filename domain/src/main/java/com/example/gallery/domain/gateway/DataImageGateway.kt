package com.example.gallery.domain.gateway

import com.example.gallery.domain.datamodel.DataList
import io.reactivex.Single

interface DataImageGateway {
    fun getDataImageListNew(): Single<DataList>
    fun getDataImageListPopular(): Single<DataList>
}