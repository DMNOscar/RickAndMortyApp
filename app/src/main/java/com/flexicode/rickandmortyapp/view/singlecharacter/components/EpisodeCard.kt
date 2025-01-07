package com.flexicode.rickandmortyapp.view.singlecharacter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.flexicode.rickandmortyapp.ui.theme.episodeColor

@Composable
fun EpisodeCard(index: String) {

    Card(

        modifier = Modifier.padding(8.dp)
    ) {


        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)) // Opcional: para bordes redondeados
                .background(Color.Gray) // Opcional: fondo en caso de que la imagen no cargue
        ) {
            AsyncImage(
                model = "https://rickandmortyapi.com/api/character/avatar/19.jpeg",
                contentDescription = "Image Episode",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize() // La imagen abarca todo el Card
            )
            Spacer(modifier = Modifier.fillMaxSize().background(episodeColor))
            Text(
                text = "Episode #$index",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }


    }
}