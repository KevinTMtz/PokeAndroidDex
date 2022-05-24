package com.example.pokedex.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PokemonsScreen(navController: NavHostController) {
    Scaffold (topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Pokedex List")
        }
    }) {
        Pokemons()
    }
}

@Composable
fun Pokemon (name: String) {
    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded. value) 48.dp else 0.dp

    Surface (color = MaterialTheme.colors.primary,
        modifier = Modifier.padding (vertical = 5. dp, horizontal = 10. dp)) {
        Row (modifier = Modifier.padding(25.dp)) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
            Text(text = "Pokemon: ")
            Text(text = name)
        }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "hide" else "catch")
            }
        }
    }
}

@Composable
private fun Pokemons (cameos: List<String> = List (10) { "$it" }) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .verticalScroll(scrollState)
    ) {
        for (cameo in cameos) {
            Pokemon(cameo)
        }
    }
}
