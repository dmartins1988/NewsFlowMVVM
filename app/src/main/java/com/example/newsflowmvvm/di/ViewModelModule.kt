package com.example.newsflowmvvm.di

import com.example.newsflowmvvm.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel { MainViewModel(get()) }

}