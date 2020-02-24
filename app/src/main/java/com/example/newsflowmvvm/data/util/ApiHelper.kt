package com.example.newsflowmvvm.data.util

import java.lang.Exception

suspend fun <T> safeApiCall(call: suspend () -> T) : Result<T> {
    return try {
        Result.Success(call.invoke())
    }catch (e: Exception) {
        Result.Error(e.message.toString())
    }
}