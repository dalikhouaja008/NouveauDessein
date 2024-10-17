package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.example.nouveaudesseinapp.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
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
import com.example.nouveaudesseinapp.Entities.Event


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    //event: Event
) {
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier =  Modifier.fillMaxSize()){
            /// Background Image
            Image(painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )
    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_account_circle),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp) // Taille réduite
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Name Here",
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = "Email Here",
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}}}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    //ProfileScreen(Event(R.drawable.food,"title","description","10/10/2024","adresse"))
    ProfileScreen()
}