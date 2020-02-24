package com.example.newsflowmvvm.data.remote

import com.example.newsflowmvvm.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val url = request
                .url()
                .newBuilder()
                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                .build()

        return chain.proceed(request.newBuilder().url(url).build())

    }

}