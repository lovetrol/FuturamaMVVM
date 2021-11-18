package com.proa.futuramamvvm.model.helpers

import com.proa.futuramamvvm.model.network.APIService
import javax.inject.Inject

class CharactersRepository
@Inject
constructor(private val apiService: APIService){
    suspend fun getCharacters() = apiService.getCharacters()
}