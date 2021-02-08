package io.arpit.ourmedium.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.arpit.ourmedium.adapter.StoriesAdapter
import io.arpit.ourmedium.databinding.FragmentStoriesBinding
import io.arpit.ourmedium.viewmodel.FeedViewModel

class StoriesFragment : Fragment() {
    lateinit var _binding: FragmentStoriesBinding
    private val viewModel: FeedViewModel by activityViewModels()
    private lateinit var adapter: StoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoriesBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StoriesAdapter()
        _binding.rvStories.layoutManager = LinearLayoutManager(context)
        _binding.rvStories.adapter = adapter

        viewModel._feed.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

    }


    override fun onDestroy() {
        super.onDestroy()
    }
}