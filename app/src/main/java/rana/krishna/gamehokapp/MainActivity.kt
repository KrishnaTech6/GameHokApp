package rana.krishna.gamehokapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import rana.krishna.gamehokapp.ui.screens.HomeScreen
import rana.krishna.gamehokapp.ui.screens.TournamentDetails
import rana.krishna.gamehokapp.ui.theme.GamehokAppTheme
import rana.krishna.gamehokapp.ui.components.BottomNavigationBar

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamehokAppTheme {
                val navController = rememberNavController()

                val currentRoute by navController.currentBackStackEntryAsState().value?.destination?.route?.let {
                    mutableStateOf(it)
                } ?: remember { mutableStateOf("home") }

                Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
                    when (currentRoute) {
                        "home" -> {}
                        "tournament_details" -> {}
                    }
                },
                    bottomBar = {
                        if (currentRoute == "home") {
                            BottomNavigationBar(navController)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("tournament_details") {
                            TournamentDetails(navController)
                        }
                    }
                }
            }
        }
    }
}
