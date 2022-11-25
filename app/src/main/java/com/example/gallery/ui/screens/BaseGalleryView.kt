package com.example.gallery.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.gallery.Constants
import com.example.gallery.domain.datamodel.ListDataItems
import com.example.gallery.ui.navigation.Screens

@Composable
fun BaseGalleryView(
    navController: NavController,
    value: List<ListDataItems>
){
    VerticalGrid(imageData = value, navController = navController)
}

@Composable
private fun VerticalGrid(imageData: List<ListDataItems>, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(imageData) { imageData ->
        ImageItem(imageData, navController)
        }
    }
}

@Composable
private fun ImageItem(data: ListDataItems, navController: NavController) {
    val imageName = remember { mutableStateOf(data.image?.name!!) }
    val title = remember { mutableStateOf(data.title!!) }
    val description = remember { mutableStateOf(data.description!!) }
    Image(
        painter = rememberAsyncImagePainter(Constants.API_URL + data.image?.name),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .height(129.dp)
            .width(179.dp)
            .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
            .clickable {
                navController.navigate(
                    Screens.Info.withArgs(imageName.value, title.value, description.value)
                )
            }
    )
}