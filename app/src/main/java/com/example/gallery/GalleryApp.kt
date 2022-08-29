package com.example.gallery

import android.app.Application
import com.example.gallery.di.AppComponent
import com.example.gallery.di.DaggerAppComponent

class GalleryApp: Application() {
//    lateinit var appComponent: AppComponent

    override fun onCreate() {
//        appComponent = DaggerAppComponent.create()
        super.onCreate()
    }
}