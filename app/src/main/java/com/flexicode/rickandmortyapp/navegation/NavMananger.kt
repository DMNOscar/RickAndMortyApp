package com.flexicode.rickandmortyapp.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexicode.rickandmortyapp.view.HomeView
import com.flexicode.rickandmortyapp.view.HomeViewModel


@Composable
fun NavManager(homeViewModel: HomeViewModel) {
    val context = LocalContext.current


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home"){
            HomeView(navController = navController,homeViewModel= homeViewModel)
        }
    }
}