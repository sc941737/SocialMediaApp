package com.sc941737.socialmediaapp.modules.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseBindingFragment
import com.sc941737.socialmediaapp.databinding.FragmentFeedBinding
import com.sc941737.socialmediaapp.modules.main.MainViewModel
import com.sc941737.socialmediaapp.repository.models.Post

class FeedFragment : BaseBindingFragment<FragmentFeedBinding>(R.layout.fragment_feed) {

    private val viewModel: FeedViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
    }

    private fun setupRV(){
        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = FeedAdapter(requireContext())
            setHasFixedSize(true)
            setItemViewCacheSize(25)
            (adapter as FeedAdapter).submitList(viewModel.posts.value)
        }
    }
}