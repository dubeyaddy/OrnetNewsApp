package com.ornet.newsapp.architecture.upload

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(private val newsDao: NewsDao) {
    fun insert(news: News) {
        newsDao.insert(news)
    }

    suspend fun getAllNews(): List<News> {
        return withContext(Dispatchers.IO){
            newsDao.getAllNews()
        }
    }
}
