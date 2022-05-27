package com.example.pokedex.data

import java.io.Serializable

open class PokemonsData (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonData>
): Serializable
