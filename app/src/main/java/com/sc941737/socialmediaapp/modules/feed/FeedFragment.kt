package com.sc941737.socialmediaapp.modules.feed

import android.content.Context
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
import com.sc941737.socialmediaapp.di.DaggerAppComponent
import com.sc941737.socialmediaapp.modules.main.MainViewModel
import com.sc941737.socialmediaapp.repository.models.Post
import com.sc941737.socialmediaapp.util.notImplemented

class FeedFragment : BaseBindingFragment<FragmentFeedBinding>(R.layout.fragment_feed), FeedAdapter.PostItemListener {

    private val viewModel: FeedViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerAppComponent.factory().create(requireActivity().applicationContext).inject(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        viewModel.posts.observe(viewLifecycleOwner){
            (binding.rvPosts.adapter as FeedAdapter).submitList(it)
        }
    }

    private fun setupRV(){
        binding.rvPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = FeedAdapter(requireContext())
            (adapter as FeedAdapter).itemListener = this@FeedFragment
            setHasFixedSize(true)
            setItemViewCacheSize(25)
        }
    }

    override fun onClickLike(item: Post) {
        view?.notImplemented()
    }

    override fun onClickComments(item: Post) {
        val action = FeedFragmentDirections.actionFeedFragmentToCommentsFragment(item.id)
        navigate(action)
    }

    override fun onClickAuthor(item: Post) {
        val action = FeedFragmentDirections.actionFeedFragmentToProfileFragment(item.authorName, item.userId)
        navigate(action)
    }
}