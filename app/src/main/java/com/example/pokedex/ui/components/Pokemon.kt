package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.data.PokemonInfo

@Composable
fun Pokemon(pokemon: PokemonInfo) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    val pokemonName = pokemon.name.replaceFirstChar { it.uppercase() }

    val focusManager = LocalFocusManager.current

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column {
            Row(modifier = Modifier.padding(25.dp)) {
                Column(
                    Modifier
                        .weight(1f)
                        .padding(bottom = extraPadding)
                ) {
                    Text(text = "Pokemon:")
                    Text(text = pokemonName)
                }

                OutlinedButton(onClick = {
                    expanded.value = !expanded.value
                    focusManager.clearFocus()
                }) {
                    Text(if (expanded.value) "Hide" else "Catch")
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