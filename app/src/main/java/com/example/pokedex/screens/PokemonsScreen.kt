package com.example.pokedex.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.mvvm.PokemonViewModel
import com.example.pokedex.ui.components.PokemonsList
import com.example.pokedex.ui.components.SearchBar
import java.util.*

@Composable
fun PokemonsScreen(navController: NavHostController) {
    val context = LocalContext.current
    val pokemonViewModel = PokemonViewModel()
    val scrollState = rememberLazyListState()

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
        val (searchStr, onSearchStrChange) = remember { mutableStateOf("") }

        val (isLoading, onIsLoadingChange) = remember { mutableStateOf(false) }

        Column {
            SearchBar(value = searchStr, onValueChange = onSearchStrChange)

            PokemonsList(
                scrollState = scrollState,
                pokemons = pokemonViewModel.listaPokemonsInfo.filter { pokemonInfo ->
                    pokemonInfo.name.contains(searchStr.lowercase(Locale.getDefault()))
                })
        }

        if (pokemonViewModel.listaPokemonsInfo.isEmpty() && !isLoading)
            getPokemons(
                context,
                pokemonViewModel,
                onIsLoadingChange,
                "Loading pokemons...",
                "Loaded pokemons..."
            )

        if (scrollState.isScrollInProgress && searchStr.isEmpty()) {
            LocalFocusManager.current.clearFocus()

            DisposableEffect(Unit) {
                onDispose {
                    if (scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == scrollState.layoutInfo.totalItemsCount - 1  && !isLoading) {
                        getPokemons(
                            context,
                            pokemonViewModel,
                            onIsLoadingChange,
                            "Loading more pokemons...",
                            "Loaded more pokemons..."
                        )
                    }
                }
            }
        }
    }
}

private fun getPokemons(
    context: Context,
    viewModel: PokemonViewModel,
    onIsLoadingChange: (Boolean) -> Unit,
    loadingMessage: String,
    loadedMessage: String,
) {
    onIsLoadingChange(true)

    Toast.makeText(context, loadingMessage, Toast.LENGTH_SHORT).show()

    viewModel.getPokemons ({
        Toast.makeText(context, loadedMessage, Toast.LENGTH_SHORT).show()
    }, {
        onIsLoadingChange(false)
    })
}
