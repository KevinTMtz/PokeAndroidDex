package com.example.pokedex.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.pokedex.data.PokemonInfo
import com.example.pokedex.mvvm.PokemonViewModel

@Composable
fun PokemonsScreen(navController: NavHostController) {
    val pokemonViewModel: PokemonViewModel = PokemonViewModel()
    Scaffold(topBar = {
        TopAppBar {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Pokedex List")
        }
    }) {
        Pokemons(pokemons = pokemonViewModel.listaPokemonsInfo)
        pokemonViewModel.getPokemons()

    }
}

@Composable
fun Pokemon(pokemon: PokemonInfo) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    val pokemonName = pokemon.name.replaceFirstChar { it.uppercase() }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Column() {
            Row(modifier = Modifier.padding(25.dp)) {
                Column(
                    Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text(text = "Pokemon: ")
                    Text(text = pokemonName)
                }
                OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                    Text(if (expanded.value) "hide" else "catch")
                }
            }
            if (expanded.value)
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "# ${pokemon.id}")
                    Text(text = "Height: ${pokemon.height}")
                    Text(text = "Weight: ${pokemon.weight}")
                    AsyncImage(
                        model = pokemon.sprites.front_default,
                        contentDescription = "Sprite of ${pokemon.name}",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
        }
    }
}

@Composable
private fun Pokemons(pokemons: List<PokemonInfo>) {
    val scrollState = rememberScrollState()
    LazyColumn {
        itemsIndexed(items = pokemons) { index, item ->
            Pokemon(pokemon = item)
        }
    }
}
