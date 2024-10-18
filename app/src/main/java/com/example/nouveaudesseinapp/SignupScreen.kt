package com.example.nouveaudesseinapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
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
import com.example.nouveaudesseinapp.viewmodel.UserViewModel
import com.example.nouveaudesseinapp.network.User
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.Entities.UserData
import com.example.nouveaudesseinapp.Repository.UserRepository
import com.example.nouveaudesseinapp.repository.UserRepository


@Composable
fun SignupScreen(
    navController: NavHostController,
    userViewModel: UserViewModel // Injecting the UserViewModel
) {
    val userRepository = UserRepository()
    var nom by remember { mutableStateOf("") }
    var cin by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {


        Box(modifier =  Modifier.fillMaxSize()){
            /// Background Image
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
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
                Image(
                    painter = painterResource(id = R.drawable.logo_blanc),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )
                Row(
                    modifier = Modifier.padding(top=12.dp, bottom = 52.dp),
                ){

                    Text("Avez vous déjà un compte? ",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            color = Color.White
                        )
                    )

                    Text("Se connecter",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            fontWeight = FontWeight(800),
                            color = Color.White
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate("signin")
                        }
                    )


                }

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
                // TextField
                CTextfield(onValueChange = {nom =it},hint = "Nom ", value = nom )
                CTextfield(onValueChange = {cin =it},hint = "CIN ", value = cin )
                CTextfield(onValueChange = {tel =it},hint = "Numéro Téléphone ", value = tel)
                CTextfield(onValueChange = {email =it},hint = "Adresse Email", value = email )
                CTextfield(onValueChange = {password =it},hint = "Mot de passe", value = password )

                Spacer(modifier = Modifier.height(24.dp))

                // Submit Button
                CButton(onClick = {
                    // Creating a User object
                    val user = User(name, cin, numTel, email, password)

                    // Call ViewModel's createUser method
                    userViewModel.createUser(user) { response ->
                        if (response.isSuccessful) {
                            // Navigate to another screen if user creation is successful
                            navController.navigate("signin")
                        } else {
                            // Handle errors, e.g., show a Toast
                        }
                    }
                }, text = "S'inscrire", Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .width(20.dp))
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