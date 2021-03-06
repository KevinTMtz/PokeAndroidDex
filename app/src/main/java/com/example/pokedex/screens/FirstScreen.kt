package com.example.pokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.ScreenNavigation

@Composable
fun FirstScreen(navController: NavHostController) {
    Scaffold (topBar = {
        TopAppBar {
            Text(text = "Pokedex", modifier = Modifier.padding(start = 8.dp))
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
        Text(text = "First screen", modifier = Modifier.padding(bottom = 32.dp))

        Button (onClick = { navController.navigate (route= ScreenNavigation. PokemonsScreen.screen) }) {
            Text (text = "Click to see pokemons")
        }
    }
}