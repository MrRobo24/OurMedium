package io.arpit.ourmedium.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.arpit.ourmedium.adapter.GlobalFeedAdapter
import io.arpit.ourmedium.databinding.FragmentGlobalFeedBinding
import io.arpit.ourmedium.viewmodel.FeedViewModel

class GlobalFeedFragment : Fragment() {

    private lateinit var _binding: FragmentGlobalFeedBinding
    private lateinit var globalFeedAdapter: GlobalFeedAdapter
    private val viewModel: FeedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentGlobalFeedBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel

        globalFeedAdapter = GlobalFeedAdapter()
        _binding.rvFeed.layoutManager = LinearLayoutManager(context)
        _binding.rvFeed.adapter = globalFeedAdapter

        viewModel.fetchGlobalFeed()
        viewModel._feed.observe(viewLifecycleOwner, Observer {
            globalFeedAdapter.submitList(it)
        })

        return _binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}