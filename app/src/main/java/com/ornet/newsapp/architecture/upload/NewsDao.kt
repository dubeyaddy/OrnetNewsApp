package com.ornet.newsapp.architecture.upload

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {
    @Insert
    fun insert(news: News)

    @Query("SELECT * FROM news_upload")
    fun getAllNews(): List<News>
}
