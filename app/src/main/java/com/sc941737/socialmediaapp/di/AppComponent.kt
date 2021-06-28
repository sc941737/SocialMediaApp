package com.sc941737.socialmediaapp.di
import android.content.Context
import com.sc941737.socialmediaapp.modules.comments.CommentsViewModel
import com.sc941737.socialmediaapp.modules.feed.FeedViewModel
import com.sc941737.socialmediaapp.modules.main.MainActivity
import com.sc941737.socialmediaapp.modules.main.MainViewModel
import com.sc941737.socialmediaapp.modules.profile.ProfileViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
    fun inject(activity: MainActivity)
    fun inject(vm: MainViewModel)
    fun inject(viewModel: FeedViewModel)
    fun inject(viewModel: CommentsViewModel)
    fun inject(viewModel: ProfileViewModel)
}