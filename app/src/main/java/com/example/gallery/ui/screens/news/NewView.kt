package com.example.gallery.ui.screens.news

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.gallery.ui.screens.BaseGalleryView
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewView(
    navController: NavController,
    viewModel: NewViewModel = koinViewModel()
) {
    BaseGalleryView(navController = navController, viewModel.dataImage.value.data.orEmpty())
}