package com.flexicode.rickandmortyapp.domain.network.dao

import com.flexicode.rickandmortyapp.domain.models.CharacterData.Character
import com.flexicode.rickandmortyapp.domain.models.CharacterData.CharactersListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkDAO {

    @GET("character")
    fun getAllCharacter() : Call<CharactersListData>

    @GET("character/{id}")
    fun getSingleCharacter(@Path("id") id: String) : Call<Character>

}