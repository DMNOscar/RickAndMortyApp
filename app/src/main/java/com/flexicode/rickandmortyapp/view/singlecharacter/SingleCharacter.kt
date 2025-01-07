package com.flexicode.rickandmortyapp.view.singlecharacter

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.flexicode.rickandmortyapp.ui.theme.blueMortyColor
import com.flexicode.rickandmortyapp.ui.theme.jerryColor
import com.flexicode.rickandmortyapp.ui.theme.rickColor
import com.flexicode.rickandmortyapp.view.home.viewmodel.HomeViewModel
import com.flexicode.rickandmortyapp.view.singlecharacter.components.EpisodeCard
import com.flexicode.rickandmortyapp.view.singlecharacter.components.InfoRow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SingleCharacter(navController: NavController, homeViewModel: HomeViewModel) {

    Scaffold(
        content = { ContentSingleCharacter(homeViewModel) })
}

@Composable
fun ContentSingleCharacter(homeViewModel: HomeViewModel) {
    val character = homeViewModel.homeState.singleCharacter

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-30).dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                model = character.image, contentDescription = "Image ${character.name}"
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(36.dp),
                elevation = CardDefaults.elevatedCardElevation(0.dp),
            ) {
                Column(modifier = Modifier.padding(top = 30.dp, start = 22.dp, end = 22.dp)) {
                    Text(
                        text = character.name.toString(),
                        style = TextStyle(fontSize = 32.sp, color = jerryColor, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Information",
                        style = TextStyle(fontSize = 18.sp, color = rickColor, fontWeight = FontWeight.Bold)
                    )

                    InfoRow(title = "Name:", data = character.name.toString())
                    InfoRow(title = "Species:", data = character.species.toString())
                    InfoRow(title = "Gender:", data = character.gender.toString())
                    InfoRow(title = "Origin:", data = character.origin?.name.toString())
                    InfoRow(title = "Location:", data = character.location?.name.toString())
                    InfoRow(title = "Status:", data = character.status.toString())
                    InfoRow(title = "Episode:", data = character.episode.size.toString())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Episode",
                        style = TextStyle(fontSize = 18.sp, color = rickColor, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow {
                        itemsIndexed(character.episode){ index, episode ->

                            EpisodeCard(index = (index + 1).toString())

                        }


                    }

                }
            }
        }

    }

}