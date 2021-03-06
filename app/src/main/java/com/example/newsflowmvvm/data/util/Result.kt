package com.example.newsflowmvvm.data.util

import java.lang.Exception

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val error: String) : Result<T>()
    object Loading : Result<Nothing>()
}