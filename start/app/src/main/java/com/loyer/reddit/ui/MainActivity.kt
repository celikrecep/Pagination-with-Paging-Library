package com.loyer.reddit.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.loyer.reddit.R
import com.loyer.reddit.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter = PostAdapter()
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        checkConnectivity()
        postList.layoutManager = LinearLayoutManager(this)
        postList.adapter = adapter
    }

    private fun checkConnectivity() {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnected
        if (!isConnected) {
            Toast.makeText(this, "check connectivity", Toast.LENGTH_SHORT).show()
        }
    }
}
