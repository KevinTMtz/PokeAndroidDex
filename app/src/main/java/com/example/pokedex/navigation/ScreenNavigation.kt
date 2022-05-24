package com.example.pokedex.navigation

sealed class ScreenNavigation(val screen : String) {
    object FirstScreen : ScreenNavigation("primera_pantalla")
    object PokemonsScreen : ScreenNavigation("pokemons_pantalla")
}