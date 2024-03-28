package com.ornet.newsapp.architecture.upload

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News_Upload")
data class News(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "newsId")
    val newsId: Int? = null,
    @ColumnInfo(name = "newsTitle")
    val newsTitle: String?,
    @ColumnInfo(name = "newsDescription")
    val newsDescription: String?,
    @ColumnInfo(name = "newsBannerImage")
    val newsBannerImage: String?,
    @ColumnInfo(name = "category")
    val category: String?,
    @ColumnInfo(name = "region")
    val region: String?,
    @ColumnInfo(name = "status")
    val status: String?,
    @ColumnInfo(name = "language")
    val language: String?,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "country")
    val country: String?,
    @ColumnInfo(name = "createdOn")
    val createdOn: String?,
    @ColumnInfo(name = "createdBy")
    val createdBy: String?,
    @ColumnInfo(name = "updatedOn")
    val updatedOn: String?,
    @ColumnInfo(name = "updatedBy")
    val updatedBy: String?
)
