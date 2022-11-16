package com.example.gallery.data.gateway

import com.example.gallery.data.storage.models.DataListResponse
import com.example.gallery.data.storage.network.GalleryApi
import com.example.gallery.domain.gateway.ImageGateway
import com.example.gallery.domain.datamodel.DataList
import io.reactivex.Single

class ImageGatewayImpl constructor(val galleryApi: GalleryApi) : ImageGateway {
    override fun getNewImages(): Single<DataList> {
        val data = galleryApi.getDataImageList(new = true)
        return mapToDomain(data)
    }

    override fun getPopularImages(): Single<DataList> {
        val data = galleryApi.getDataImageList(popular = true)
        return mapToDomain(data)
    }

    private fun mapToDomain(dataListResponse: Single<DataListResponse>): Single<DataList> {
        return dataListResponse.map {
            com.example.gallery.domain.datamodel.DataList(it.data?.map { dataListDataItems ->
                with(dataListDataItems) {
                    com.example.gallery.domain.datamodel.ListDataItems(
                        com.example.gallery.domain.datamodel.ImageItem(image?.name),
                        title,
                        description
                    )
                }
            }
            )
        }
    }
}