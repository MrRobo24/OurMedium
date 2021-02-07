package io.arpit.ourmedium.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import io.arpit.ourmedium.databinding.FragmentPersonalFeedBinding
import io.arpit.ourmedium.viewmodel.FeedViewModel

class PersonalFeedFragment : Fragment() {

    private lateinit var _binding: FragmentPersonalFeedBinding
    private val viewModel: FeedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPersonalFeedBinding.inflate(inflater, container, false)
        _binding.viewModel = viewModel

        return _binding.root
    }

}