package com.sc941737.socialmediaapp.modules.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseBindingFragment
import com.sc941737.socialmediaapp.databinding.FragmentCommentsBinding
import com.sc941737.socialmediaapp.modules.main.MainViewModel

class CommentsFragment : BaseBindingFragment<FragmentCommentsBinding>(R.layout.fragment_comments) {

    private val viewModel: CommentsViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.fragment = this
        binding.viewModel = viewModel
        return binding.root
    }
}