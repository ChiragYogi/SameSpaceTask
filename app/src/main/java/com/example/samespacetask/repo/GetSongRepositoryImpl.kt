package com.example.samespacetask.repo

import com.example.samespacetask.network.GetSongsListService
import com.example.samespacetask.ui.model.SongsData
import com.example.samespacetask.utills.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import javax.inject.Inject
import retrofit2.HttpException
import java.io.IOException

class GetSongRepositoryImpl @Inject constructor(private val getSongsListService: GetSongsListService) :
    GetSongRepository {
    override suspend fun getSongList(): Resource<SongsData> {

        return try {
            withContext(Dispatchers.IO) {
                val response = getSongsListService.getSongsFromApi()
                val result = response.body()
                if (response.isSuccessful && result != null) {
                    Resource.Success(result)
                } else {
                    Resource.Error(response.message())
                }
            }
        } catch (io: IOException) {
            Resource.Error(io.message ?: "An error occurred")
        } catch (http: HttpException) {
            Resource.Error(http.message ?: "An error occurred")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}