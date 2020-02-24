package com.example

import android.app.Application
import com.example.newsflowmvvm.di.NetworkModule
import com.example.newsflowmvvm.di.RepositoryModule
import com.example.newsflowmvvm.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NewsApp)
            modules(listOf(NetworkModule, RepositoryModule, ViewModelModule))
        }
    }

}