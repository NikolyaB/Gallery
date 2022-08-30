package com.example.gallery

import android.app.Application
import com.example.gallery.di.AppComponent
import com.example.gallery.di.AppModule
import com.example.gallery.di.DaggerAppComponent

class GalleryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}