package com.example.gallery.domain.usecase

import com.example.gallery.domain.gateway.DataImageGateway
import com.example.gallery.domain.datamodel.DataList
import io.reactivex.Single

class GetDataImageListNewUseCase(private val dataImageGateway: DataImageGateway) {
    fun execute(): Single<DataList> {
        return dataImageGateway.getDataImageListNew()
    }
}