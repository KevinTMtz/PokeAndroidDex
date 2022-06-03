package com.example.pokedex.service

import com.example.pokedex.data.PokemonInfo
import com.example.pokedex.data.PokemonsData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeMonApi {
    @GET("pokemon")
    suspend fun getPokemonsList(
        @Query("offset") offset: Int? = 20,
        @Query("limit") limit: Int? = 20,
    ): PokemonsData

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name:String): PokemonInfo

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