package com.example.gallery.ui.navigation

import androidx.annotation.StringRes
import com.example.gallery.R

sealed class Screens(val route: String, @StringRes val resourceStringId: Int) {
    object Info: Screens("Info", R.string.info_route)


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg->
                    append("?$arg")
            }
        }
    }
}