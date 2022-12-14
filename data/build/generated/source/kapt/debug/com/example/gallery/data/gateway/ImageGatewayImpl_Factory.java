// Generated by Dagger (https://dagger.dev).
package com.example.gallery.data.gateway;

import com.example.gallery.data.storage.network.GalleryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ImageGatewayImpl_Factory implements Factory<ImageGatewayImpl> {
  private final Provider<GalleryApi> galleryApiProvider;

  public ImageGatewayImpl_Factory(Provider<GalleryApi> galleryApiProvider) {
    this.galleryApiProvider = galleryApiProvider;
  }

  @Override
  public ImageGatewayImpl get() {
    return newInstance(galleryApiProvider.get());
  }

  public static ImageGatewayImpl_Factory create(Provider<GalleryApi> galleryApiProvider) {
    return new ImageGatewayImpl_Factory(galleryApiProvider);
  }

  public static ImageGatewayImpl newInstance(GalleryApi galleryApi) {
    return new ImageGatewayImpl(galleryApi);
  }
}
