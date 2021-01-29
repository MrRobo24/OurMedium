package io.arpit.ourmedium.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.arpit.api.models.entities.Article
import io.arpit.ourmedium.repository.ArticlesRepository
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val TAG = "FeedVM"
    val _feed = MutableLiveData<List<Article>>()
//    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() {
        viewModelScope.launch {
            val res = kotlin.runCatching {
                ArticlesRepository.getGlobalFeed()
            }

            res.onSuccess {
                _feed.postValue(it.body()?.articles)
                Log.d(TAG, "Articles Response received: Count ${_feed.value?.size}")
            }

            res.onFailure {
                Log.d(TAG, "Articles Response: ${it.message}")
            }
        }
    }

}