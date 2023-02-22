package com.example.cryptoexplorer.di

import com.example.cryptoexplorer.data.remote.CoinPaprikaApi
import com.example.cryptoexplorer.data.repository.CoinRepositoryImpl
import com.example.cryptoexplorer.domain.repository.CoinRepository
import com.example.cryptoexplorer.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi() : CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.PAPRIKA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}