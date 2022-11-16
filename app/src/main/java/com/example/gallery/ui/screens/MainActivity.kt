package com.example.gallery.ui.screens

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gallery.ui.screens.bottomNavigation.AppBottomNavigation
import com.example.gallery.ui.screens.bottomNavigation.BottomNavigationScreens
import com.example.gallery.ui.navigation.MainScreenNavigationConfigurations


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val bottomNavigationItems = listOf(
                BottomNavigationScreens.New,
                BottomNavigationScreens.Popular
            )

            Scaffold(
                bottomBar = {
                    AppBottomNavigation(navController, bottomNavigationItems)
                }
            ) { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    MainScreenNavigationConfigurations(navController)
                }
            }
        }
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return ev?.getPointerCount()!! <= 3 && super.dispatchTouchEvent(ev)
    }

}