package com.loyer.reddit.ui

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.loyer.reddit.model.Post
import com.loyer.reddit.R
import kotlinx.android.synthetic.main.list_item_post.view.*

class PostAdapter: PagedListAdapter<Post,PostAdapter.ViewHolder>(diffUtilCallBack) {

    companion object {
        private val diffUtilCallBack =
                object : DiffUtil.ItemCallback<Post>(){
                    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                        return oldItem.key == newItem.key
                    }

                    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                        return oldItem.title == newItem.title
                                && oldItem.score == newItem.score
                                && oldItem.commentCount == newItem.commentCount                    }

                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_post))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var post: Post? = null
        fun bind(post: Post?){
            this.post = post
            itemView.title.text = post?.title
            itemView.score.text = post?.score.toString()
            itemView.comments.text = post?.commentCount.toString()
        }
    }
}