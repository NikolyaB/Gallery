package com.example.gallery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gallery.ui.screens.bottomNavigation.BottomNavigationScreens
import com.example.gallery.ui.screens.detailImages.InfoView
import com.example.gallery.ui.screens.news.NewView
import com.example.gallery.ui.screens.populars.PopularView

@Composable
public fun MainScreenNavigationConfigurations(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = BottomNavigationScreens.New.route) {
        composable(BottomNavigationScreens.New.route) {
            NewView(navController)
        }
        composable(BottomNavigationScreens.Popular.route) {
            PopularView(navController)
        }
        

        composable(
            route = Screens.Info.route + "?{imageName}?{title}?{description}",
            arguments = listOf(
                navArgument("imageName") {
                    type = NavType.StringType
                    defaultValue = " "
                },
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = " "
                },
                navArgument("description") {
                    type = NavType.StringType
                    defaultValue = " "
                }
        )) { entry ->
            InfoView(
                imageName = entry.arguments?.getString("imageName").toString(),
                title = entry.arguments?.getString("title").toString(),
                description = entry.arguments?.getString("description").toString())
        }
    }
}