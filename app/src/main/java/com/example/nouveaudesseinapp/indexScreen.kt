package com.example.nouveaudesseinapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nouveaudesseinapp.ui.theme.NouveauDesseinAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val currentScreen = remember { mutableStateOf("posts") }
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Nouveau Dessein") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {currentScreen.value = "profile"}) {
                        Icon(Icons.Filled.Info, contentDescription = "Info")
                    }
                    MoreOption(navController)
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            ButtonRow { screen -> currentScreen.value = screen }
            when (currentScreen.value) {
                "posts" -> PostList(navController)
                "form" -> FormScreen()
                "profile" -> ProfileScreen()
                // "about" -> AboutFragment()
            }
        }
    }
}
@Composable
fun MoreOption( navController: NavHostController) {
    var expanded by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopEnd)) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Filled.MoreVert, contentDescription = "More")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            DropdownMenuItem(onClick = {
                navController.navigate("ListParticipation")
            }, text = { Text("Vos prochaines participations") })
            DropdownMenuItem(onClick = {
                //navController.navigate("ListParticipation")
            }, text = { Text("Vos demandes de remboursement") })
            DropdownMenuItem(onClick = {
                expanded = false
                showDialog = true

            }, text = { Text("Se déconnecter") })
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "LOG OUT") },
            text = { Text("Are you sure you want to log out?") },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    navController.navigate("signin")
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("No")
                }
            }
        )
    }
}
@Composable
fun ButtonRow(onNavigate: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Augmentez le padding pour un look plus aéré
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Style commun pour les boutons
        val buttonModifier = Modifier
            .weight(1f)
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp)) // Coins arrondis

        Button(
            onClick = { onNavigate("posts") },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)) // Couleur personnalisée
        ) {
            Text(text = "Posts", color = Color.White)
        }

        Button(
            onClick = { onNavigate("form") },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)) // Couleur personnalisée
        ) {
            Text(text = "Form", color = Color.White)
        }

        Button(
            onClick = { onNavigate("profile") },
            modifier = buttonModifier,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C9A92)) // Couleur personnalisée
        ) {
            Text(text = "Profil", color = Color.White)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NouveauDesseinAppTheme {
        MainScreen(rememberNavController())
    }
}