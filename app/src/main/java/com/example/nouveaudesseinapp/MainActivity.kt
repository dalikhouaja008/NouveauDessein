package com.example.nouveaudesseinapp

import android.os.Bundle // Make sure to import Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.nouveaudesseinapp.viewmodel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set content
        setContent {
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
