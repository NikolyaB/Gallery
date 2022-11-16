package com.example.gallery.ui.screens.bottomNavigation

import androidx.annotation.StringRes
import com.example.gallery.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceStringId: Int, val resourceIconId: Int) {
        object New : BottomNavigationScreens("New", R.string.new_route, R.drawable.ic_new)
        object Popular : BottomNavigationScreens("Popular", R.string.popular_route, R.drawable.ic_popular)
}
