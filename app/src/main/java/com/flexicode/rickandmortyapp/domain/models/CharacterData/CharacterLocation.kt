package com.flexicode.rickandmortyapp.domain.models.CharacterData

import com.google.gson.annotations.SerializedName

data class CharacterLocation(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)
