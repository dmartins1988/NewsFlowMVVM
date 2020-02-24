package com.example.newsflowmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsflowmvvm.data.NewsRepository
import com.example.newsflowmvvm.data.util.Result
import com.example.newsflowmvvm.model.TopNewsResponse
import kotlinx.coroutines.Dispatchers

class MainViewModel(
    newsRepository: NewsRepository
) : ViewModel() {

    private val _topNews = newsRepository
        .getTopNews()
        .asLiveData(Dispatchers.IO + viewModelScope.coroutineContext)

    val topNews : LiveData<Result<TopNewsResponse>> get() = _topNews

}
