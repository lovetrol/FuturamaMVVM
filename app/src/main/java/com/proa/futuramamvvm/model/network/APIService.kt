package com.proa.futuramamvvm.model.network

import com.proa.futuramamvvm.model.FuturamaCharacters
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("futurama/characters")
    suspend fun getCharacters() : Response<FuturamaCharacters>
}