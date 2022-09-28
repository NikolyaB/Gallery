package com.example.gallery.data.storage.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/gallery/data/storage/network/GalleryApi;", "", "getDataImageList", "Lio/reactivex/Single;", "Lcom/example/gallery/data/storage/models/DataListResponse;", "new", "", "popular", "data_debug"})
public abstract interface GalleryApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Headers(value = {"ContentType: application/json"})
    @retrofit2.http.GET(value = "photos")
    public abstract io.reactivex.Single<com.example.gallery.data.storage.models.DataListResponse> getDataImageList(@retrofit2.http.Query(value = "new")
    boolean p0_54480, @retrofit2.http.Query(value = "popular")
    boolean popular);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}