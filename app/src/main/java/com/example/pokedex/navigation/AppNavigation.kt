package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.screens.FirstScreen
import com.example.pokedex.screens.PokemonsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost (navController = navController, startDestination =
    ScreenNavigation.FirstScreen.screen) {
        composable(route = ScreenNavigation.FirstScreen.screen) {
            FirstScreen(navController)
        }

        composable(route = ScreenNavigation.PokemonsScreen.screen) {
            PokemonsScreen(navController)
        }
    }
}
