package com.example.gallery.ui.screens.populars

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.gallery.ui.screens.BaseGalleryView
import org.koin.androidx.compose.koinViewModel

@Composable
fun PopularView(
    navController: NavController,
    viewModel: PopularViewModel = koinViewModel()
) {
    BaseGalleryView(navController = navController, viewModel.resultLive.value?.data.orEmpty())
}