package com.example.gallery.ui.screens.news

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.gallery.ui.screens.BaseGalleryView
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewView(
    navController: NavController,
    viewModel: NewViewModel = koinViewModel()
) {
    val vm = viewModel.resultLive.observeAsState()
    Log.e("takblin", vm.value.toString())
    BaseGalleryView(navController = navController, viewModel.resultLive.value?.data.orEmpty())
}