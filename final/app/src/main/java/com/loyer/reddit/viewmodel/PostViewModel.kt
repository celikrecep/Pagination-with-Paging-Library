package com.loyer.reddit.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.loyer.reddit.model.Post
import com.loyer.reddit.network.PostDataSource

class PostViewModel(application: Application): AndroidViewModel(application) {
    //1
    private val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
    //2
    val allPosts = initializedPagedListBuilder(config).build()


    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<String, Post> {

        val dataSourceFactory = object : DataSource.Factory<String, Post>() {
            override fun create(): DataSource<String, Post> {
                return PostDataSource()
            }
        }
        return LivePagedListBuilder<String, Post>(dataSourceFactory, config)
    }

}