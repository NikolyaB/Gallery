package com.example.gallery

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gallery.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@SuppressLint("StaticFieldLeak")

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bNav : BottomNavigationView = binding.bNav

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_new, R.id.navigation_popular
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bNav.setupWithNavController(navController)
    }
}