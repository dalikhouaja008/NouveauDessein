package com.example.nouveaudesseinapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.nouveaudesseinapp.components.CButton
import com.example.nouveaudesseinapp.components.CTextfield
import com.example.nouveaudesseinapp.components.DontHaveAccountRow
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {


        Box(modifier =  Modifier
            .fillMaxSize()){
            /// Background Image
            Image(painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .matchParentSize()

            )

            /// Content

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(painter = painterResource(id = R.drawable.logo_blanc),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 1.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )

                Text(text = "Connectez-vous",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(text = "",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(text = "",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )





                CTextfield(onValueChange = {email =it},hint = "Adresse Email", value = email )

                CTextfield(onValueChange = {password =it},hint = "mot de passe", value = password )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(
                    onClick = {
                        email=""
                        password=""
                        navController.navigate("index")

                    },
                    text = "Se Connecter",
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .width(20.dp))
                DontHaveAccountRow(
                    onSignupTap = {
                        navController.navigate("signup")
                    }
                )

            }

        }

    }

}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}