package com.sc941737.socialmediaapp.di

import com.sc941737.socialmediaapp.repository.SocialApi
import com.sc941737.socialmediaapp.util.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideSocialApi():SocialApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SocialApi::class.java)

}
