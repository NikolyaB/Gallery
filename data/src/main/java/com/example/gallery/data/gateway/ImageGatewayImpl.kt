package com.example.gallery.data.gateway

import com.example.gallery.data.storage.models.DataListResponse
import com.example.gallery.data.storage.network.GalleryApi
import com.example.gallery.domain.gateway.ImageGateway
import com.example.gallery.domain.datamodel.DataList
import com.example.gallery.domain.datamodel.ImageItem
import com.example.gallery.domain.datamodel.ListDataItems
import io.reactivex.Single
import javax.inject.Inject

class ImageGatewayImpl @Inject constructor(private val galleryApi: GalleryApi) :
    ImageGateway {
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