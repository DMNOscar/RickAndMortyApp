package com.flexicode.rickandmortyapp.view.singlecharacter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun InfoRow(title:String, data: String){

    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row (horizontalArrangement = Arrangement.Start){
            Text(text = title, style = TextStyle(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = data, textAlign = TextAlign.Start)
        }
    }
}