package com.loyer.reddit.ui

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.loyer.reddit.model.Post
import com.loyer.reddit.R

class PostAdapter: PagedListAdapter<Post,PostAdapter.ViewHolder>(diffUtilCallBack) {

    companion object {
        private val diffUtilCallBack =
                object : DiffUtil.ItemCallback<Post>(){
                    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                        TODO("not implemented")
                    }

                    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                        TODO("not implemented")
                    }

                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_post))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented")
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //bind method
    }
}