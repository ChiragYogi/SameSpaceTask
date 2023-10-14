package com.example.samespacetask.network

import com.example.samespacetask.ui.model.SongItemDetail
import com.example.samespacetask.ui.model.SongsData
import retrofit2.Response
import retrofit2.http.GET

interface GetSongsListService {

    @GET("items/songs")
    suspend fun getSongsFromApi(): Response<SongsData>
}