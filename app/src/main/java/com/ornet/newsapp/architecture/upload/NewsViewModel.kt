package com.ornet.newsapp.architecture.upload

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    fun insert(news: News) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(news)
        }
    }

    fun getAllNews(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNews()
        }
    }

    class NewsViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NewsViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return NewsViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
