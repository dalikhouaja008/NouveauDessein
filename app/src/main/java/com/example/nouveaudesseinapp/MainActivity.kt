package com.example.nouveaudesseinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.Entities.Event
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.nouveaudesseinapp.viewmodel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val list:MutableList<Event> = mutableListOf()
            val navController= rememberNavController()
            NavHost(navController,startDestination = "splachScreen") {
                composable("splachScreen"){WelcomeScreen(navController)}
                composable("signup") {SignupScreen(navController)  }
                composable("signin") { LoginScreen(navController) }
                composable("index") { MainScreen(navController) }
                composable("postList") {  PostList(navController)}
                composable("form") { FormScreen() }
                composable("ListParticipation"){ListParticipation(navController,list)}
                composable("postDetail/{imageId}/{title}/{description}/{adresse}/{date}") {
                    backStackEntry ->
                    val imageId = backStackEntry.arguments?.getString("imageId")?.toInt()
                    val title = backStackEntry.arguments?.getString("title")
                    val description = backStackEntry.arguments?.getString("description")
                    val adresse = backStackEntry.arguments?.getString("adresse")
                    val date = backStackEntry.arguments?.getString("date")
                    DetailPostScreen(imageId,title, description, adresse, date,navController,list)
                }



            }
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel() // Initialize UserViewModel

    NavHost(navController, startDestination = "signup") {
        composable("signup") {
            SignupScreen(navController, userViewModel) // Pass the UserViewModel
        }
        // Add other destinations here
        composable("signin") {
            WelcomeScreen(navController) // Ensure you have a SigninScreen
        }
    }
}

