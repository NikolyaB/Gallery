package com.example.gallery.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gallery.domain.datamodel.DataList

abstract class BaseGalleryViewModel(): ViewModel() {
    val dataImage: MutableState<DataList> = mutableStateOf(DataList(ArrayList()))
    open fun getData() {}
}