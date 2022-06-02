package com.example.pokedex.data

data class PokemonInfo(
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val weight: Int
)