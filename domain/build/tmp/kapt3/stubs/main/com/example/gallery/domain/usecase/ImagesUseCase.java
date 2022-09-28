package com.example.gallery.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/gallery/domain/usecase/ImagesUseCase;", "", "imageGateway", "Lcom/example/gallery/domain/gateway/ImageGateway;", "(Lcom/example/gallery/domain/gateway/ImageGateway;)V", "getNewImages", "Lio/reactivex/Single;", "Lcom/example/gallery/domain/datamodel/DataList;", "getPopularImages", "domain"})
public final class ImagesUseCase {
    private final com.example.gallery.domain.gateway.ImageGateway imageGateway = null;
    
    @javax.inject.Inject()
    public ImagesUseCase(@org.jetbrains.annotations.NotNull()
    com.example.gallery.domain.gateway.ImageGateway imageGateway) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getNewImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.example.gallery.domain.datamodel.DataList> getPopularImages() {
        return null;
    }
}