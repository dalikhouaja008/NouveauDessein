package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.Entities.Event
import com.example.nouveaudesseinapp.components.CardProfile
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily


@Composable
fun ListParticipation(
    navController: NavController,
    list: MutableList<Event>
){
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier =  Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("index")
                    },
                    modifier = Modifier.align(Alignment.Start)

                    ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retour",
                        tint = Color.White
                    )
                }
                Text(text = "Liste des bénévolats réservés",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),

                    )
                listCards(navController, list)
            }
        }
    }
}


@Composable
fun listCards( navController: NavController,  events: List<Event>) {


    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        items(events) { event ->
            CardProfile(
                idImage = event.imagePath,
                title = event.title,
                date = event.date,
                adresse = event.adresse
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun ListParticipationPreview() {
    ListParticipation(rememberNavController(),  mutableListOf(
        Event(R.drawable.food, "Concert", "Un concert incroyable.", "2024-10-17", "123 Rue Exemple"),
        Event(R.drawable.food, "Exposition", "Une exposition d'art moderne.", "2024-11-01", "456 Avenue Exemple"),
        Event(R.drawable.food, "Festival", "Un festival de musique.", "2024-12-05", "789 Boulevard Exemple"),
        Event(R.drawable.food, "Conférence", "Une conférence sur la technologie.", "2024-09-15", "321 Route Exemple")
    )
    )

}