package com.flexicode.rickandmortyapp.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flexicode.rickandmortyapp.view.home.HomeView
import com.flexicode.rickandmortyapp.view.home.viewmodel.HomeViewModel
import com.flexicode.rickandmortyapp.view.singlecharacter.SingleCharacter


@Composable
fun NavManager(homeViewModel: HomeViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home"){
            HomeView(navController = navController,homeViewModel= homeViewModel)
        }
        composable(route = "single"){
            SingleCharacter(navController = navController, homeViewModel = homeViewModel)
        }
    }
}