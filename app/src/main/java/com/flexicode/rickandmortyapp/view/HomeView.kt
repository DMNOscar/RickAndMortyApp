package com.flexicode.rickandmortyapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.flexicode.rickandmortyapp.domain.models.CharacterData.Character

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, homeViewModel: HomeViewModel) {
    Scaffold(
        content = {
            HomeContent(homeViewModel)
        }
    )
}



@Composable
fun HomeContent(homeViewModel: HomeViewModel){
    val characterList = homeViewModel.homeState.characterData.results

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Especifica que quieres 2 columnas
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
       items(characterList){ character -> CharacterCard(character = character, homeViewModel = homeViewModel)
           
       }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(character: Character, homeViewModel: HomeViewModel ) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxHeight()
            .padding(12.dp)
        ,
        onClick = {
            homeViewModel.getSingleCharacter(character.id.toString())
        }) {

        Column (modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            AsyncImage(model = character.image, contentDescription ="Image ${character.name}")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = character.name.toString())
            Text(text = character.species.toString())
            Text(text = character.gender.toString())
            Text(text = character.status.toString())
        }
    }

}