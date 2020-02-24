package com.example.newsflowmvvm.data

import com.example.newsflowmvvm.data.remote.NewsService
import com.example.newsflowmvvm.data.util.Result
import com.example.newsflowmvvm.data.util.safeApiCall
import kotlinx.coroutines.flow.flow

class NewsRepository(
    private val newsService: NewsService
) {

    fun getTopNews() = flow {

        emit(Result.Loading)

        emit(safeApiCall { newsService.topNews() })

    }

}