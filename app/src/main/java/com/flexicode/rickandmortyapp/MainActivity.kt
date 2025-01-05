package com.flexicode.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.flexicode.rickandmortyapp.navegation.NavManager
import com.flexicode.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.flexicode.rickandmortyapp.view.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel: HomeViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            RickAndMortyAppTheme {
               NavManager(homeViewModel)
            }
        }
    }
}


