package com.example.gallery.ui.screens.bottomNavigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gallery.R
import com.example.gallery.ui.screens.BaseGalleryView

@Composable
fun AppBottomNavigation(navController: NavHostController,
                        items: List<BottomNavigationScreens>
) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),

    ) {
        items.forEach { screen ->
            val currentRoute = currentRoute(navController = navController)
            val selected = currentRoute == screen.route
            BottomNavigationItem(
                selected = selected,
                label = { Text(
                    stringResource(id = screen.resourceStringId),
                    color = if (selected) colorResource(id = R.color.pink) else colorResource(id = R.color.gray))
                },
                icon = { Icon(
                    painterResource(id = screen.resourceIconId),
                    contentDescription = stringResource(id = screen.resourceStringId),
                    tint = if (selected) colorResource(id = R.color.pink) else colorResource(id = R.color.gray))
                },
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val backStackEntry = navController.currentBackStackEntryAsState()
    return backStackEntry.value?.destination?.route
}

