package com.flexicode.rickandmortyapp.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flexicode.rickandmortyapp.domain.models.CharacterData.Character
import com.flexicode.rickandmortyapp.domain.models.CharacterData.CharactersListData
import com.flexicode.rickandmortyapp.domain.models.HomeState
import com.flexicode.rickandmortyapp.domain.network.dao.NetworkDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val networkDAO: NetworkDAO) : ViewModel() {

    var homeState by mutableStateOf(HomeState())
        private set

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() {
        homeState = homeState.copy(isLoad = true)
        viewModelScope.launch {

            networkDAO.getAllCharacter().enqueue(object : Callback<CharactersListData> {
                override fun onResponse(
                    call: Call<CharactersListData>,
                    response: Response<CharactersListData>,
                ) {

                    if (response.code().equals(200)) {
                        homeState = homeState.copy(
                            isLoad = false,
                            characterData = response.body() as CharactersListData
                        )

                    } else {
                        homeState = homeState.copy(
                            isLoad = false,
                            onFailureRequester = true,
                        )
                    }
                }

                override fun onFailure(call: Call<CharactersListData>, t: Throwable) {

                    homeState = homeState.copy(
                        isLoad = false,
                        onFailureRequester = true,
                    )

                }

            })

        }
    }

    fun getSingleCharacter(id: String){
        homeState = homeState.copy(isLoad = true)
        viewModelScope.launch {

            networkDAO.getSingleCharacter(id).enqueue(object : Callback<Character> {
                override fun onResponse(call: Call<Character>, response: Response<Character>) {
                    if (response.code().equals(200)){
                        homeState = homeState.copy(
                            isLoad = false,
                            singleCharacter =  response.body() as Character

                        )
                    }
                }

                override fun onFailure(call: Call<Character>, t: Throwable) {

                }
            })

        }

    }
}