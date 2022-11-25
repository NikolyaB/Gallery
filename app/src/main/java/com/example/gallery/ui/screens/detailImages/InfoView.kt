package com.example.gallery.ui.screens.detailImages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.gallery.Constants
import com.example.gallery.R
import kotlinx.coroutines.internal.OpDescriptor

@Composable
fun InfoView(imageName: String?, title: String?, description: String?) {
    Column(modifier = Modifier.fillMaxHeight()) {

        Image(
            painter = rememberAsyncImagePainter(model = (Constants.API_URL + imageName)),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .height(229.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
        )
        Text(text = "$title",
            modifier = Modifier
                .padding(12.dp),
            color = colorResource(id = R.color.blue),
            fontSize = 20.sp
        )
        Text(text = "$description", modifier = Modifier.padding(12.dp))
    }
}