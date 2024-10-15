package com.example.nouveaudesseinapp

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily
import com.example.nouveaudesseinapp.ui.theme.components.CButton
import com.example.nouveaudesseinapp.ui.theme.components.CTextfield

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    modifier: Modifier = Modifier
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current // Correctly retrieve the current context.
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri // Set the selected image URI

        // Decode the image based on Android version.
        uri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap = ImageDecoder.decodeBitmap(source)
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
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
                modifier = Modifier.padding(top = 54.dp).height(100.dp).align(Alignment.Start).offset(x = (-20).dp)
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

            CTextfield(hint = "Description ...", value="")
            CTextfield(hint = "Adresse ...", value="")

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
            ) {
                // Display selected image if available or a placeholder.
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Uploaded Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp))
                    )
                } ?: run {
                    // Placeholder for the uploaded image if none is selected.
                    Image(
                        painter = painterResource(id = R.drawable.upload), // Placeholder image resource.
                        contentDescription = "Upload Placeholder",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(50.dp).clip(RoundedCornerShape(8.dp))
                    )
                }

                // Button to upload an image.
                CButton(onClick = { launcher.launch("image/*") }, text = "Upload Image")
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

@Preview(showBackground = true)
@Composable
fun PreviewFormScreen() {
    FormScreen()
}