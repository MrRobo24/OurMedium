package io.arpit.ourmedium.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.arpit.api.models.entities.Article
import io.arpit.ourmedium.R
import io.arpit.ourmedium.databinding.StoriesRowBinding

class StoriesAdapter :
    ListAdapter<Article, StoriesAdapter.StoriesViewHolder>(
        object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.toString() == newItem.toString()
            }

        }
    ) {


    inner class StoriesViewHolder(val binding: StoriesRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StoriesRowBinding.inflate(layoutInflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val article = getItem(position)
        //setting image for story
        Glide.with(holder.binding.imgStory.context)
            .load(article.author.image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .apply(RequestOptions().circleCrop())
            .into(holder.binding.imgStory)
    }
}