package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.example.nouveaudesseinapp.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.colelcte),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth() // Remplit la largeur du conteneur
                .height(150.dp) // Définissez une hauteur fixe pour l'image
                .clip(RoundedCornerShape(8.dp)), // Arrondir les coins de l'image
            contentScale = ContentScale.Crop // Pour couper l'image si elle dépasse
        )

        Text(
            text = "Name Here",
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = "Email Here",
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
        ProfileScreen()
}