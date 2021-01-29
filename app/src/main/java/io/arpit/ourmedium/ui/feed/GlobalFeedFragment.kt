package io.arpit.ourmedium.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.arpit.ourmedium.databinding.FragmentFeedBinding
import io.arpit.ourmedium.viewmodel.FeedViewModel

class GlobalFeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private var viewModel: FeedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}