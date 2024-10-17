package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily
import com.example.nouveaudesseinapp.ui.theme.adresse1
import com.example.nouveaudesseinapp.ui.theme.adresse2
import com.example.nouveaudesseinapp.ui.theme.adresse3
import com.example.nouveaudesseinapp.ui.theme.adresse4
import com.example.nouveaudesseinapp.ui.theme.date1
import com.example.nouveaudesseinapp.ui.theme.date2
import com.example.nouveaudesseinapp.ui.theme.date3
import com.example.nouveaudesseinapp.ui.theme.date4
import com.example.nouveaudesseinapp.ui.theme.desc1
import com.example.nouveaudesseinapp.ui.theme.desc2
import com.example.nouveaudesseinapp.ui.theme.desc3
import com.example.nouveaudesseinapp.ui.theme.desc4
import com.example.nouveaudesseinapp.ui.theme.title1
import com.example.nouveaudesseinapp.ui.theme.title2
import com.example.nouveaudesseinapp.ui.theme.title3
import com.example.nouveaudesseinapp.ui.theme.title4

@Composable
fun PostList(navController: NavHostController) {
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

            LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(4) { index ->
            when (index) {
                0 -> CardPost(
                    idImage = R.drawable.colelcte,
                    title = title1,
                    description = desc1,
                    adresse = adresse1,
                    date = date1,
                    onClick = {
                        navController.navigate("postDetail/${R.drawable.colelcte}/$title1/$desc1/$adresse1/$date1")
                    }
                )
                1 -> CardPost(
                    idImage = R.drawable.planter_un_arbre,
                    title = title2,
                    description = desc2,
                    adresse = adresse2,
                    date = date2,
                    onClick = {
                        navController.navigate("postDetail/${R.drawable.planter_un_arbre}/$title2/$desc2/$adresse2/$date2")
                    }
                )
                2 -> CardPost(
                    idImage = R.drawable.food,
                    title = title3,
                    description = desc3,
                    adresse = adresse3,
                    date = date3,
                    onClick = {
                        navController.navigate("postDetail/${R.drawable.food}/$title3/$desc3/$adresse3/$date3")
                    }
                )
                3 -> CardPost(
                    idImage = R.drawable.ecole,
                    title = title4,
                    description = desc4,
                    adresse = adresse4,
                    date = date4,
                    onClick = {
                        navController.navigate("postDetail/${R.drawable.ecole}/$title4/$desc4/$adresse4/$date4")
                    }
                )
            }
        }
    }}}
}


@Composable
fun CardPost(idImage: Int, title: String,description: String,adresse : String, date: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
            .border(2.dp, Color.White, RoundedCornerShape(8.dp))


    ) {
        Column(modifier = Modifier.padding(5.dp).background(Color.Transparent)) {
            Image(
                painter = painterResource(id = idImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(text = title, style = TextStyle(
                fontSize = 18.sp,
                fontFamily = AlegreyaSansFontFamily,
                fontWeight = FontWeight(300),
                color = Color.Black
            )
            )
            Text(text = description, style = TextStyle(
                fontSize = 13.sp,
                fontFamily = AlegreyaSansFontFamily,
                fontWeight = FontWeight(300),
                color = Color.Black
            ))
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween // Répartit les éléments avec de l'espace entre eux
            ) {
                Text(
                    text = adresse,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(300),
                        color = Color.Black
                    )
                )
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(300),
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostScreen() {
    PostList(rememberNavController())
    //PostList()
}

