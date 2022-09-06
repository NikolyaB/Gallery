package com.example.gallery.di

import com.example.gallery.ui.screens.news.NewFragment
import com.example.gallery.ui.screens.populars.PopularFragment
import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class])
interface AppComponent {
    fun inject(fragment: NewFragment)
    fun inject(fragment: PopularFragment)
}