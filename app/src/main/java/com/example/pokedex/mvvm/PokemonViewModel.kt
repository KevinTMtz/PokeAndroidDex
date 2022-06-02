package com.example.pokedex.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonData
import com.example.pokedex.data.PokemonInfo
import com.example.pokedex.service.PokeMonApi
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    var listaPokemonsInfo: List<PokemonInfo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getPokemons(){
        viewModelScope.launch {
            val apiService = PokeMonApi.getInstance()
            try{
                val pokemons = apiService.getPokemonsList()
                val pokemonsInfo = mutableListOf<PokemonInfo>()
                for(pokemon in pokemons.results){
                    val info = apiService.getPokemonInfo(pokemon.name)
                    pokemonsInfo.add(info)
                }
                listaPokemonsInfo = pokemonsInfo
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}