package com.example.gallery.data.gateway

import android.telephony.mbms.DownloadStatusListener
import android.util.Log
import com.example.gallery.data.storage.models.DataListResponse
import com.example.gallery.data.storage.network.GalleryServiceImpl
import com.example.gallery.domain.gateway.ImageGateway
import com.example.gallery.domain.datamodel.DataList
import com.example.gallery.domain.datamodel.ImageItem
import com.example.gallery.domain.datamodel.ListDataItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageGatewayImpl constructor(val galleryServiceImpl: GalleryServiceImpl) : ImageGateway {
    override suspend fun getNewImages() = mapToDomain(galleryServiceImpl.getDataImageList("new"))
    override suspend fun getPopularImages() = mapToDomain(galleryServiceImpl.getDataImageList("popular"))

    private fun mapToDomain(dataList: DataListResponse): DataList {
        return DataList(data = dataList.data?.map {
            ListDataItems(ImageItem(it.image?.name), it.title, it.description)
        })
    }
}

