package com.loyer.reddit.network

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.loyer.reddit.model.Post
import com.loyer.reddit.model.RedditApiResponse
import com.loyer.reddit.model.RedditListing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostDataSource: PageKeyedDataSource<String, Post>() {

    private val api = Api.createService()

    override fun loadInitial(
            params: PageKeyedDataSource.LoadInitialParams<String>,
            callback: PageKeyedDataSource.LoadInitialCallback<String, Post>) {
        val liveData = MutableLiveData<List<Post>>()
        var paging: RedditListing?

        api.getPosts(loadSize = params.requestedLoadSize).enqueue(object :
                Callback<RedditApiResponse> {
            override fun onResponse(call: Call<RedditApiResponse>, response: Response<RedditApiResponse>?) {
                if(response != null && response.isSuccessful){
                    paging = response.body()?.data
                    liveData.value = paging?.children?.map { it.data }
                    callback.onResult(liveData.value ?: listOf(), paging?.before, paging?.after)
                } else {
                    liveData.value = null
                }

            }
            override fun onFailure(call: Call<RedditApiResponse>, t: Throwable) {
                liveData.value = null
            }
        })

    }

    override fun loadAfter(
            params: PageKeyedDataSource.LoadParams<String>,
            callback: PageKeyedDataSource.LoadCallback<String, Post>) {

        val liveData = MutableLiveData<List<Post>>()
        var paging: RedditListing?

        api.getPosts(loadSize = params.requestedLoadSize, after = params.key).enqueue(object :
                Callback<RedditApiResponse>{
            override fun onResponse(call: Call<RedditApiResponse>, response: Response<RedditApiResponse>?) {
                if(response != null && response.isSuccessful){
                    paging = response.body()?.data
                    liveData.value = paging?.children?.map { it.data }
                    callback.onResult(liveData.value ?: listOf(),  paging?.after)
                } else {
                    liveData.value = null
                }

            }
            override fun onFailure(call: Call<RedditApiResponse>, t: Throwable) {
                liveData.value = null
            }
        })
    }

    override fun loadBefore(
            params: PageKeyedDataSource.LoadParams<String>,
            callback: PageKeyedDataSource.LoadCallback<String, Post>) {

        TODO("not implemented")
    }
}
