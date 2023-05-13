package com.enimal.app.data.repositories

import android.util.Log
import com.enimal.app.data.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ) : Resource<T> {
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable : Throwable){
                Log.d("TAG_ERROR_ENTAH_APA", throwable.message.toString())
                when (throwable){
                    is HttpException -> {
                        Resource.Failure(false,throwable.code(),throwable.response()?.errorBody())
                    } else -> {
                        Resource.Failure(true,null,null)
                    }
                }
            }
        }
    }
}