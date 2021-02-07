package io.arpit.ourmedium.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import io.arpit.ourmedium.adapter.FeedAdapter
import io.arpit.ourmedium.databinding.FragmentFeedBinding
import io.arpit.ourmedium.viewmodel.FeedViewModel

class FeedFragment : Fragment() {

    private lateinit var _binding: FragmentFeedBinding
    private lateinit var feedAdapter: FeedAdapter
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        feedAdapter = FeedAdapter(this)
        _binding.pager.adapter = feedAdapter

        TabLayoutMediator(_binding.tabLayout, _binding.pager) { tab, position ->
            when (position) {
                0 -> tab.text = "Global Feed"
                1 -> tab.text = "Personal Feed"

            }
        }.attach()
    }
}

