package com.example.gallery.domain.gateway;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/gallery/domain/gateway/ImageGateway;", "", "getNewImages", "Lio/reactivex/Single;", "Lcom/example/gallery/domain/datamodel/DataList;", "getPopularImages", "domain"})
public abstract interface ImageGateway {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getNewImages();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getPopularImages();
}