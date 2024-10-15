package com.example.nouveaudesseinapp

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily
import com.example.nouveaudesseinapp.ui.theme.components.CButton
import com.example.nouveaudesseinapp.ui.theme.components.CTextfield


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
modifier: Modifier = Modifier
) {
    var imageUri = remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext
    var bitmap = remember { mutableStateOf<Bitmap?>(null) }







    Box(modifier = modifier.fillMaxSize())
    {
       Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()

        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_blanc),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 54.dp)
                    .height(100.dp)
                    .align(Alignment.Start)
                    .offset(x = (-20).dp)
            )
            Text(
                text = "Poster votre contribution",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.align(Alignment.Start).padding(bottom = 24.dp)
            )
            Text(
                text = "Poster maintenant pour avoir une réduction d'impôt",
                style = TextStyle(
                    fontSize = 12.5.sp,
                    fontFamily = AlegreyaFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xB2FFFFFF),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.align(Alignment.Start).padding(bottom = 24.dp)
            )
            CTextfield(hint = "Description ...",value="")
            CTextfield(hint = "Adresse ...",value="")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween, // Adjust as needed
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
            ) {
                // Placeholder for the uploaded image
                Image(
                    painter = painterResource(id = R.drawable.upload), // Replace with actual image resource or state variable
                    contentDescription = "Uploaded Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp)) // Optional: Add rounded corners
                )

                // Button to upload an image
                CButton(onClick = { }, text = "Upload image")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween, // Adjust as needed
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
            ) {
                // Placeholder for the uploaded image
                Image(
                    painter = painterResource(id = R.drawable.upload), // Replace with actual image resource or state variable
                    contentDescription = "Uploaded Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(8.dp)) // Optional: Add rounded corners
                )

                // Button to upload an image
                CButton(onClick = { }, text = "Upload facture")
            }
            CButton(onClick = {}, text = "Envoyer")

        }
    }

}



@Preview(showBackground = true, widthDp= 320,heightDp= 640)
@Composable
fun FormScreenPreview(){
    FormScreen()
}
