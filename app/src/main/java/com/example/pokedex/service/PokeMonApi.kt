package com.example.pokedex.service

import com.example.pokedex.data.PokemonsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeMonApi {
    @GET("pokemon")
    suspend fun getPokemonsList(): PokemonsData

    companion object{
        var apiService: PokeMonApi ?= null
        fun getInstance(): PokeMonApi{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(PokeMonApi::class.java)
            }
            return apiService!!
        }
    }
}