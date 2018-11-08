package com.loyer.reddit.network

import com.loyer.reddit.model.RedditApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/r/funny/hot.json")
    fun getPosts(@Query("limit") loadSize: Int = 30,
                 @Query("after") after: String? = null,
                 @Query("before") before: String? = null): Call<RedditApiResponse>

    companion object {
        private const val BASE_URL = "https://www.reddit.com/"

        fun createService(): Api {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api::class.java)
        }
    }
}
