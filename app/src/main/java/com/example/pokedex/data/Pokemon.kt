package com.example.pokedex.data

import java.io.Serializable

open class Pokemon (
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypes>
): Serializable
