package io.arpit.ourmedium.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.arpit.api.models.entities.Article
import io.arpit.ourmedium.databinding.FeedArticleRowBinding

class GlobalFeedAdapter : ListAdapter<Article, GlobalFeedAdapter.GlobalFeedViewHolder>(
    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }
) {

    inner class GlobalFeedViewHolder(val binding: FeedArticleRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlobalFeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FeedArticleRowBinding.inflate(layoutInflater, parent, false)
        return GlobalFeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GlobalFeedViewHolder, position: Int) {
        val article = getItem(position)

        holder.binding.apply {
            txtUsername.text = article.author.username
            txtTitle.text = article.title
            txtBody.text = article.body
            txtDateCreated.text = article.createdAt

            executePendingBindings()
        }

    }

}