package com.flexicode.rickandmortyapp.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.flexicode.rickandmortyapp.view.home.components.CharacterCard
import com.flexicode.rickandmortyapp.view.home.components.SearchBarApp
import com.flexicode.rickandmortyapp.view.home.viewmodel.HomeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, homeViewModel: HomeViewModel) {
    Scaffold(
        topBar = {
            SearchBarApp { name ->
                homeViewModel.searchChareater(name)
            }
        },
        content = { paddingValues ->
            HomeContent(
                navController,
                homeViewModel,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun HomeContent(navController: NavController, homeViewModel: HomeViewModel, modifier: Modifier) {
    val characterList = homeViewModel.homeState.characterData.results

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characterList) { character ->
            CharacterCard(
                navController = navController,
                character = character,
                homeViewModel = homeViewModel
            )

        }
    }
}
