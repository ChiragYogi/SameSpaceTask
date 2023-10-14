package com.example.samespacetask.repo



import com.example.samespacetask.ui.model.SongsData
import com.example.samespacetask.utills.Resource


interface GetSongRepository {
    suspend fun getSongList(): Resource<SongsData>
}