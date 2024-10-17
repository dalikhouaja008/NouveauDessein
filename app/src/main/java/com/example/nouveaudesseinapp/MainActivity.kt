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
        }
    }
}

