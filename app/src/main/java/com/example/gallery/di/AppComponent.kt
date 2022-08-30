package com.example.gallery.di

import com.example.gallery.ui.screens.NewFragment
import com.example.gallery.ui.screens.PopularFragment
import dagger.Component

@Component(modules = [
    AppModule::class,
    DataModule::class,
    DomainModule::class,
    NetworkModule::class])
interface AppComponent {
    fun inject(fragment: NewFragment)
    fun inject(fragment: PopularFragment)
}