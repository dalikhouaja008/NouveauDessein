package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.components.CButton
import com.example.nouveaudesseinapp.components.CTextfield
import com.example.nouveaudesseinapp.components.DontHaveAccountRow
import com.example.nouveaudesseinapp.ui.theme.AlegreyaFontFamily
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily
import androidx.navigation.compose.rememberNavController


@Composable
fun SignupScreen(
    navController: NavHostController
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

            /// Content

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(painter = painterResource(id = R.drawable.logo_blanc),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )

                Text(text = "Créer un compte",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )

                Text("Créer un compte gratuitement et rejoignez-nous pour un nouveau dessein.",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = AlegreyaSansFontFamily,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )
                // Text Field
                CTextfield(hint = "Nom ", value = "" )
                CTextfield(hint = "CIN ", value = "" )
                CTextfield(hint = "Numéro Téléphone ", value = "" )
                CTextfield(hint = "Adresse Email", value = "" )
                CTextfield(hint = "Mot de passe", value = "" )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(onClick = { }, text = "S'inscrire",Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .width(20.dp))
            }

                Row(
                    modifier = Modifier.padding(top=12.dp, bottom = 52.dp)
                ){
                    Text("Avez vous déjà un compte? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            color = Color.White
                        )
                    )

                    Text("Se connecter",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            fontWeight = FontWeight(800),
                            color = Color.White
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )


                }

            }

        }

    }


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignupScreenPreview() {
    val navController = rememberNavController()
    SignupScreen(navController)
}