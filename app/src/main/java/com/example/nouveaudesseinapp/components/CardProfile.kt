package com.example.nouveaudesseinapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardProfile(idImage:Int,title:String,date:String,adresse:String){
    Card (
        modifier = Modifier.fillMaxWidth().padding(8.dp),
    ){
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = adresse , color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 13.sp)


            }
        }
    }
}