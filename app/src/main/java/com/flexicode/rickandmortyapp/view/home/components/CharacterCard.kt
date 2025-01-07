package com.flexicode.rickandmortyapp.view.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.flexicode.rickandmortyapp.domain.models.CharacterData.Character
import com.flexicode.rickandmortyapp.ui.theme.jerryColor
import com.flexicode.rickandmortyapp.ui.theme.rickColor
import com.flexicode.rickandmortyapp.view.home.viewmodel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    navController: NavController,
    character: Character,
    homeViewModel: HomeViewModel,
) {
    val roundedCornerImage = 160.dp
    ElevatedCard(
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.elevatedCardElevation(0.dp),
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal =  12.dp),
        onClick = {
            homeViewModel.getSingleCharacter(character.id.toString())
            navController.navigate("single")
        }) {

        Column(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            AsyncImage(
                contentScale = ContentScale.Crop,
                model = character.image,
                contentDescription = "Image ${character.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(roundedCornerImage)
                 //   .clip(RoundedCornerShape(18.dp))
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = character.name.toString(),
                textAlign = TextAlign.Start,
                maxLines = 1,
                style = TextStyle(
                    color = jerryColor,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = character.origin?.name.toString(),
                textAlign = TextAlign.Start,
                style = TextStyle(
                    color = rickColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )

        }
    }

}