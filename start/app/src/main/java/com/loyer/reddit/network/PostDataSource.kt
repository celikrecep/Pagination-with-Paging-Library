package com.loyer.reddit.network

import android.arch.paging.PageKeyedDataSource
import com.loyer.reddit.model.Post


class PostDataSource: PageKeyedDataSource<String, Post>() {

    private val api = Api.createService()

    override fun loadInitial(
            params: PageKeyedDataSource.LoadInitialParams<String>,
            callback: PageKeyedDataSource.LoadInitialCallback<String, Post>) {
        TODO("not implemented")

    }

    override fun loadAfter(
            params: PageKeyedDataSource.LoadParams<String>,
            callback: PageKeyedDataSource.LoadCallback<String, Post>) {

        TODO("not implemented")
    }

    override fun loadBefore(
            params: PageKeyedDataSource.LoadParams<String>,
            callback: PageKeyedDataSource.LoadCallback<String, Post>) {

        TODO("not implemented")
    }
}
