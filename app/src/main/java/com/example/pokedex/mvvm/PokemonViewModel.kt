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
    var listaPokemons: List<PokemonData> by mutableStateOf(listOf())
    var listaPokemonsInfo: List<PokemonInfo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getPokemons(){
        viewModelScope.launch {
            val apiService = PokeMonApi.getInstance()
            try{
                val pokemons = apiService.getPokemonsList()
                listaPokemons = pokemons.results
                val infos = mutableListOf<PokemonInfo>()
                for(pokemon in listaPokemons){
                    val info = apiService.getPokemonInfo(pokemon.name)
                    infos.add(info)
                }
                listaPokemonsInfo = infos
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}