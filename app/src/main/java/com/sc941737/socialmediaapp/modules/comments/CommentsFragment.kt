package com.sc941737.socialmediaapp.modules.comments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseBindingFragment
import com.sc941737.socialmediaapp.databinding.FragmentCommentsBinding
import com.sc941737.socialmediaapp.di.DaggerAppComponent
import com.sc941737.socialmediaapp.modules.main.MainViewModel
import com.sc941737.socialmediaapp.repository.models.Comment
import com.sc941737.socialmediaapp.util.notImplemented

class CommentsFragment : BaseBindingFragment<FragmentCommentsBinding>(R.layout.fragment_comments),
    CommentsAdapter.CommentItemListener {

    private val viewModel: CommentsViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private val args: CommentsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel.postId = args.postId
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
        viewModel.comments.observe(viewLifecycleOwner){
            (binding.rvComments.adapter as CommentsAdapter).submitList(it)
        }
    }

    private fun setupRV() {
        binding.rvComments.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CommentsAdapter(requireContext())
            (adapter as CommentsAdapter).itemListener = this@CommentsFragment
            setHasFixedSize(true)
            setItemViewCacheSize(25)
        }
    }

    fun onClickAddComment(){
        view?.notImplemented()
    }

    override fun onClickAuthor(item: Comment) {
//        val action = CommentsFragmentDirections.actionPostFragmentToProfileFragment(item.authorName, item.userId)
//        navigate(action)
    }
}