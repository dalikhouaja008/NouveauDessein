package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.Entities.Event
import com.example.nouveaudesseinapp.components.CButton
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily

@Composable
fun DetailPostScreen(
    imagePath: Int?,
    title: String?,
    description: String?,
    adresse: String?,
    date: String?,
    navController: NavHostController,
    eventList: MutableList<Event> // Liste mutable d'événements
) {
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.bg1),
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
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.Start)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retour",
                        tint = Color.White
                    )
                }

                imagePath?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(2.dp, Color.White, RoundedCornerShape(12.dp)) // Add border
                            .shadow(4.dp, RoundedCornerShape(12.dp)), // Add shadow
                        contentScale = ContentScale.Crop
                    )
                }

                title?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = AlegreyaSansFontFamily,
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                    )
                }

                description?.let {
                    Text(
                        text = it,
                        color = Color.White,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = AlegreyaSansFontFamily,
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Place, // Remplacez par l'icône souhaitée
                        contentDescription = "Adresse",
                        tint = Color(0xFF7C9A92)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    adresse?.let {
                        Text(
                            text = it,
                            color = Color.White,
                            fontFamily = AlegreyaSansFontFamily,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                    }
                }

                // Affichage de la date avec une icône
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange, // Remplacez par l'icône souhaitée
                        contentDescription = "Date",
                        tint = Color(0xFF7C9A92)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    date?.let {
                        Text(
                            text = it,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                    }
                }

                CButton(
                    onClick = {
                        // Créer un nouvel événement si toutes les valeurs sont non nulles
                        if (imagePath != null && title != null && description != null && date != null && adresse != null) {
                            val event =
                                Event(imagePath, title, description, date, adresse) // Créez l'événement

                            eventList.add(event) // Ajoutez l'événement à la liste

                            navController.navigate("ListParticipation") // Naviguez vers ListParticipation
                        }
                    },
                    text = "Participer",
                    Modifier.fillMaxWidth().height(50.dp).width(20.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    DetailPostScreen(
        imagePath = R.drawable.food, // Remplacez par une image valide
        title = "Titre de l'article",
        description = "Ceci est une description détaillée de l'article.",
        adresse = "123 Rue Exemple",
        date = "17 Octobre 2024",
        rememberNavController(),
        mutableListOf(
            Event(R.drawable.food, "Concert", "Un concert incroyable.", "2024-10-17", "123 Rue Exemple"),
            Event(R.drawable.food, "Exposition", "Une exposition d'art moderne.", "2024-11-01", "456 Avenue Exemple"),
            Event(R.drawable.food, "Festival", "Un festival de musique.", "2024-12-05", "789 Boulevard Exemple"),
            Event(R.drawable.food, "Conférence", "Une conférence sur la technologie.", "2024-09-15", "321 Route Exemple")
        )
    )
}


