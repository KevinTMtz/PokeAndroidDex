package com.example.pokedex.mvvm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonData
import com.example.pokedex.service.PokeMonApi
import kotlinx.coroutines.launch
import java.lang.Exception

class PokemonViewModel: ViewModel() {
    var listaPokemons: List<PokemonData> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getPokemons(){
        viewModelScope.launch {
            val apiService = PokeMonApi.getInstance()
            try{
                val pokemons = apiService.getPokemonsList()
                listaPokemons = pokemons.results
                Log.i("Pokedex", listaPokemons.toString())
            }
            catch (e: Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}