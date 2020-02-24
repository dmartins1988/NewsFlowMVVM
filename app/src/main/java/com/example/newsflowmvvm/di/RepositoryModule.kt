package com.example.newsflowmvvm.di

import com.example.newsflowmvvm.data.NewsRepository
import org.koin.dsl.module

val RepositoryModule = module {

    factory { NewsRepository(get()) }

}