package com.example.newsflowmvvm.di

import com.example.newsflowmvvm.BuildConfig
import com.example.newsflowmvvm.data.remote.AuthInterceptor
import com.example.newsflowmvvm.data.remote.NewsService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {

    factory<Interceptor> { AuthInterceptor() }

    factory { OkHttpClient.Builder().addInterceptor(get()).build() }

    single { Retrofit.Builder()
        .client(get())
        .baseUrl(BuildConfig.SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    }

    factory { get<Retrofit>().create(NewsService::class.java) }
}