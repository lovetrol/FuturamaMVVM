package com.proa.futuramamvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proa.futuramamvvm.model.FuturamaCharacters
import com.proa.futuramamvvm.model.helpers.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(private val repository: CharactersRepository) : ViewModel() {

    private val _response = MutableLiveData<FuturamaCharacters>()
    val characterResponse: LiveData<FuturamaCharacters>
        get() = _response

    init {
        getCharactersFuturama()
    }

    private fun getCharactersFuturama() = viewModelScope.launch {
        repository.getCharacters().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }
}