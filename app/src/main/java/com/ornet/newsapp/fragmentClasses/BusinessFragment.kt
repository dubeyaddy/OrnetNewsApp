package com.ornet.newsapp.fragmentClasses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ornet.newsapp.MainActivity
import com.ornet.newsapp.NewsModel
import com.ornet.newsapp.R
import com.ornet.newsapp.ReadNewsActivity
import com.ornet.newsapp.adapters.CustomAdapter
import com.ornet.newsapp.utils.Constants.NEWS_CONTENT
import com.ornet.newsapp.utils.Constants.NEWS_DESCRIPTION
import com.ornet.newsapp.utils.Constants.NEWS_IMAGE_URL
import com.ornet.newsapp.utils.Constants.NEWS_PUBLICATION_TIME
import com.ornet.newsapp.utils.Constants.NEWS_SOURCE
import com.ornet.newsapp.utils.Constants.NEWS_TITLE
import com.ornet.newsapp.utils.Constants.NEWS_URL

class BusinessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business, container, false)
        val newsData: MutableList<NewsModel> = MainActivity.businessNews
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = CustomAdapter(newsData)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val intent = Intent(context, ReadNewsActivity::class.java).apply {
                    putExtra(NEWS_URL, newsData[position].url)
                    putExtra(NEWS_TITLE, newsData[position].headLine)
                    putExtra(NEWS_IMAGE_URL, newsData[position].image)
                    putExtra(NEWS_DESCRIPTION, newsData[position].description)
                    putExtra(NEWS_SOURCE, newsData[position].source)
                    putExtra(NEWS_PUBLICATION_TIME, newsData[position].time)
                    putExtra(NEWS_CONTENT, newsData[position].content)
                }

                startActivity(intent)

            }
        })

        // Ignore
        adapter.setOnItemLongClickListener(object : CustomAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int) = Unit
        })

        return view
    }

}