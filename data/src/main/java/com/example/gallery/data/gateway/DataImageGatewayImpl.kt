package com.example.gallery.data.gateway

import com.example.gallery.data.storage.models.DataListResponse
import com.example.gallery.data.storage.network.GalleryApi
import com.example.gallery.domain.gateway.DataImageGateway
import com.example.gallery.domain.datamodel.DataList
import com.example.gallery.domain.datamodel.ImageItem
import com.example.gallery.domain.datamodel.ListDataItems
import io.reactivex.Single

class DataImageGatewayImpl(private val galleryApi: GalleryApi) : DataImageGateway {
    override fun getDataImageListNew(): Single<DataList> {
        val data = galleryApi.getDataImageList(new=true)
        return mapToDomain(data)
    }

    override fun getDataImageListPopular(): Single<DataList> {
        val data = galleryApi.getDataImageList(popular=true)
        return mapToDomain(data)
    }

    private fun mapToDomain(dataListResponse: Single<DataListResponse>): Single<DataList> {
        return dataListResponse.map {
            DataList(it.data.map { dataListDataItems ->
                with(dataListDataItems) {
                    ListDataItems(
                        ImageItem(image.name),
                        title,
                        description
                    )
                }
            }
            )
        }
    }


}