package com.sc941737.socialmediaapp.modules.photos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.sc941737.socialmediaapp.R
import com.sc941737.socialmediaapp.base.BaseBindingFragment
import com.sc941737.socialmediaapp.databinding.FragmentPhotosBinding
import com.sc941737.socialmediaapp.di.DaggerAppComponent

class PhotosFragment : BaseBindingFragment<FragmentPhotosBinding>(R.layout.fragment_photos) {

    val viewModel: PhotosViewModel by viewModels()
    private val args: PhotosFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel.albumId = args.albumId
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerAppComponent.factory().create(requireActivity().applicationContext).inject(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        viewModel.photos.observe(viewLifecycleOwner){
            (binding.rvPhotos.adapter as PhotosAdapter).submitList(it)
        }
    }

    private fun setupRV() {
        binding.rvPhotos.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = PhotosAdapter(requireContext())
            setHasFixedSize(true)
            setItemViewCacheSize(25)
        }
    }
}