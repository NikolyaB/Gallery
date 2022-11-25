package com.example.gallery

import android.app.Application
import com.example.gallery.di.appModule
import com.example.gallery.di.dataModule
import com.example.gallery.di.domainModule
import com.example.gallery.di.networkModule
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GalleryApp : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@GalleryApp)
            modules(listOf(networkModule, appModule, dataModule, domainModule))
        }

    }

    companion object {
        private val debounceState = MutableStateFlow { }

        init {
            GlobalScope.launch(Dispatchers.Main) {
                // IMPORTANT: Make sure to import kotlinx.coroutines.flow.collect
                debounceState
                    .debounce(10)
                    .collect { onClick ->
                        onClick.invoke()
                    }
            }
        }

        fun debounceClicks(onClick: () -> Unit) {
            debounceState.value = onClick
        }
    }
}