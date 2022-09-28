package com.example.gallery.data.gateway;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/gallery/data/gateway/ImageGatewayImpl;", "Lcom/example/gallery/domain/gateway/ImageGateway;", "galleryApi", "Lcom/example/gallery/data/storage/network/GalleryApi;", "(Lcom/example/gallery/data/storage/network/GalleryApi;)V", "getNewImages", "Lio/reactivex/Single;", "Lcom/example/gallery/domain/datamodel/DataList;", "getPopularImages", "mapToDomain", "dataListResponse", "Lcom/example/gallery/data/storage/models/DataListResponse;", "data_debug"})
public final class ImageGatewayImpl implements com.example.gallery.domain.gateway.ImageGateway {
    private final com.example.gallery.data.storage.network.GalleryApi galleryApi = null;
    
    @javax.inject.Inject()
    public ImageGatewayImpl(@org.jetbrains.annotations.NotNull()
    com.example.gallery.data.storage.network.GalleryApi galleryApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getNewImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getPopularImages() {
        return null;
    }
    
    private final io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> mapToDomain(io.reactivex.Single<com.example.gallery.data.storage.models.DataListResponse> dataListResponse) {
        return null;
    }
}