package com.example.newsflowmvvm.data.remote

import com.example.newsflowmvvm.model.TopNewsResponse
import retrofit2.http.GET

interface NewsService {

    @GET("top-headlines?sources=techcrunch")
    suspend fun topNews() : TopNewsResponse

}