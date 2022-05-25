package com.example.pokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.ScreenNavigation

@Composable
fun FirstScreen(navController: NavHostController) {
    Scaffold (topBar = {
        TopAppBar() {
            Text(text = "Pokedex")
        }
    }) {
        Detail(navController)
    }
}

@Composable
fun Detail(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Primera Pantalla")

        Button (onClick = { navController.navigate (route= ScreenNavigation. PokemonsScreen.screen) }) {
            Text (text = "Click para ver pokemons")
        }
    }
}