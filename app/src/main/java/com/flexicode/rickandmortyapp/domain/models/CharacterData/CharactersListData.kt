package com.flexicode.rickandmortyapp.domain.models.CharacterData

import com.google.gson.annotations.SerializedName

data class CharactersListData(

    @SerializedName("info"    ) var info: InfoCharacter?              = InfoCharacter(),
    @SerializedName("results" ) var results: List<Character> = arrayListOf()

)