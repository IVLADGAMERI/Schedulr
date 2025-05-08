package com.cmd.schedulr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cmd.schedulr.ui.theme.SchedulrTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cmd.schedulr.ui.components.BottomNavigationBar
import com.cmd.schedulr.ui.screen.CalendarScreen
import com.cmd.schedulr.ui.screen.HomeScreen
import com.cmd.schedulr.ui.screen.NavRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SchedulrTheme {
                val navController = rememberNavController()
                val navBackStackEntry = navController.currentBackStackEntryAsState().value
                val currentRoute = navBackStackEntry?.destination?.route
                val selectedItem = NavRoute.fromRoute(currentRoute)
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(
                            selectedItem = selectedItem,
                            onItemSelected = {
                                item ->
                                    if (item.route != currentRoute) {
                                        navController.navigate(item.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                            }
                        )
                    }
                ) { innerPadding ->
                    AppNavHost(padding = innerPadding, navController = navController)
                }
            }
        }
    }

    @Composable
    fun AppNavHost(
        navController: NavHostController,
        padding: PaddingValues,
    ) {
        NavHost(
            navController = navController,
            startDestination = NavRoute.Home.route
        ) {
            composable(NavRoute.Home.route) { HomeScreen(navController) }
            composable(NavRoute.Calendar.route) { CalendarScreen(navController) }
        }
    }
}