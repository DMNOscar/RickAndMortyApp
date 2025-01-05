package com.flexicode.rickandmortyapp.domain.models

import com.flexicode.rickandmortyapp.domain.models.CharacterData.Character
import com.flexicode.rickandmortyapp.domain.models.CharacterData.CharactersListData

data class HomeState(

    val isLoad : Boolean = false,
    val onFailureRequester : Boolean = false,
    val characterData: CharactersListData = CharactersListData(),
    val singleCharacter: Character = Character()

)
