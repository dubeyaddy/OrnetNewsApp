package com.ornet.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.ornet.newsapp.architecture.NewsDatabase
import com.ornet.newsapp.architecture.upload.News
import com.ornet.newsapp.architecture.upload.NewsRepository
import com.ornet.newsapp.architecture.upload.NewsViewModel
import com.ornet.newsapp.databinding.ActivityAddNewsBinding

class AddNewsActivity : AppCompatActivity() {

    lateinit var addNewsBinding : ActivityAddNewsBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var news_Id : String
    private lateinit var news_Title : String
    private lateinit var news_Description : String
    private lateinit var new_Banner_Image : String
    private lateinit var category : String
    private lateinit var region : String
    private lateinit var status : String
    private lateinit var language : String
    private lateinit var city : String
    private lateinit var country : String
    private lateinit var createdOn : String
    private lateinit var createdBy : String
    private lateinit var updatedOn : String
    private lateinit var updatedBy : String

    private val newsCategories = arrayOf(
        "Select Category","Politics", "Education", "Health", "Business", "Sports", "Entertainment", "Technology", "Science", "Travel", "Miscellaneous"
    )

    private val newsRegion = arrayOf(
        "Select Region","National", "International"
    )

    private val statusList = arrayOf(
        "Select Status","Draft", "Approved", "Published"
    )

    private val languageList = arrayOf(
        "Select Language","English","Hindi","Marathi","Spanish","French"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addNewsBinding = ActivityAddNewsBinding.inflate(layoutInflater)
        setContentView(addNewsBinding.root)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Initializing ViewModel
        val database = NewsDatabase.getDatabaseClient(this)
        val newsDao = database.newsUploadDao()
        val repository = NewsRepository(newsDao)
        val viewModelfactory = NewsViewModel.NewsViewModelFactory(repository)
        newsViewModel = ViewModelProvider(this,viewModelfactory)[NewsViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        initialize()
        addNewsBinding.btnSubmit.setOnClickListener(View.OnClickListener {
            validateNews()
        })
    }

    //Initializing dropdown adapter
    private fun initialize() {
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,newsCategories)
        addNewsBinding.dropDownCategories.setAdapter(categoryAdapter)
        addNewsBinding.dropDownCategories.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                category = newsCategories[p2]
                Log.e("AddNews",category)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@AddNewsActivity,"Please select category",Toast.LENGTH_SHORT).show()
            }
        }

        val regionAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,newsRegion)
        addNewsBinding.dropDownRegion.setAdapter(regionAdapter)
        addNewsBinding.dropDownRegion.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                region = newsRegion[p2]
                Log.e("AddNews",category)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@AddNewsActivity,"Please select category",Toast.LENGTH_SHORT).show()
            }
        }

        val statusAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,statusList)
        addNewsBinding.dropDownStatus.setAdapter(statusAdapter)
        addNewsBinding.dropDownStatus.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                status = statusList[p2]
                Log.e("AddNews",category)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@AddNewsActivity,"Please select category",Toast.LENGTH_SHORT).show()
            }
        }

        val languageAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,languageList)
        addNewsBinding.dropDownLanguage.setAdapter(languageAdapter)
        addNewsBinding.dropDownLanguage.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                language = languageList[p2]
                Log.e("AddNews",category)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@AddNewsActivity,"Please select category",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateNews() {
        news_Title = addNewsBinding.etTitle.text.toString()
        news_Description = addNewsBinding.etDescription.text.toString()
        city = addNewsBinding.etCity.text.toString()
        country = addNewsBinding.etCountry.text.toString()
        createdOn = System.currentTimeMillis().toString()

        if (!isStringValid(news_Title)) {
            Toast.makeText(this, "Invalid news title", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(news_Description)) {
            Toast.makeText(this, "Invalid news description", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(category)) {
            Toast.makeText(this, "Invalid news category", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(region)) {
            Toast.makeText(this, "Invalid news region", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(status)) {
            Toast.makeText(this, "Invalid news status", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(language)) {
            Toast.makeText(this, "Invalid news language", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(city)) {
            Toast.makeText(this, "Invalid city", Toast.LENGTH_SHORT).show()
        }
        if (!isStringValid(country)) {
            Toast.makeText(this, "Invalid country", Toast.LENGTH_SHORT).show()
        }

        saveNews()
    }

    private fun saveNews() {
        val news = News(
            newsTitle = news_Title,
            newsDescription = news_Description,
            newsBannerImage = "",
            category = category,
            region = region,
            status = status,
            language = language,
            city = city,
            country = country,
            createdOn = createdOn,
            createdBy = "",
            updatedOn = createdOn,
            updatedBy = ""
        )

        newsViewModel.insert(news)
        Toast.makeText(this,"Successfully update into db",Toast.LENGTH_SHORT).show()
        finish()
    }

    fun isStringValid(str: String?): Boolean {
        return !str.isNullOrBlank()
    }
}