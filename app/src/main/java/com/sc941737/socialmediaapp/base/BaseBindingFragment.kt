package com.sc941737.socialmediaapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.sc941737.socialmediaapp.R

abstract class BaseBindingFragment<T : ViewDataBinding>(private val layoutId: Int): Fragment() {
    lateinit var navController: NavController
    lateinit var binding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        try { navController = findNavController() } catch (ignored:Exception){}
        return binding.root
    }

    override fun onDestroy() {
        binding.unbind()
        super.onDestroy()
    }

    protected open fun getNavOptions(): NavOptions? {
        return NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
    }

    fun navigate(to:Int, args: Bundle? = null){
        navController.navigate(to, args, getNavOptions())
    }

    fun navigate(to: Int) { // For binding visibility, because null args are not recognised properly
        navigate(to, null)
    }

    fun navigate(to: NavDirections){
        navController.navigate(to, getNavOptions())
    }
}