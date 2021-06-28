package com.sc941737.socialmediaapp.modules.profile

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
import com.sc941737.socialmediaapp.databinding.FragmentProfileBinding
import com.sc941737.socialmediaapp.di.DaggerAppComponent
import com.sc941737.socialmediaapp.modules.main.MainViewModel
import com.sc941737.socialmediaapp.repository.models.Album

class ProfileFragment : BaseBindingFragment<FragmentProfileBinding>(R.layout.fragment_profile), ProfileAdapter.AlbumItemListener {

    private val viewModel: ProfileViewModel by viewModels()
    private val sharedViewModel: MainViewModel by activityViewModels()
    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel.currentUserId = args.userId
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
        viewModel.user.observe(viewLifecycleOwner){
            it?.let {
                (binding.rvAlbums.adapter as ProfileAdapter).submitList(it.albums)
            }
        }
    }

    private fun setupRV() {
        binding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ProfileAdapter(requireContext())
            (adapter as ProfileAdapter).itemListener = this@ProfileFragment
            setHasFixedSize(true)
            setItemViewCacheSize(25)
        }
    }

    override fun onClickAlbum(item:Album){
        val action = ProfileFragmentDirections.actionProfileFragmentToPhotosFragment(item.id)
        navigate(action)
    }
}