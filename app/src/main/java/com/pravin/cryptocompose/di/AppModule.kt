package com.pravin.cryptocompose.di

import com.pravin.cryptocompose.common.Constants
import com.pravin.cryptocompose.common.Constants.BASE_URL
import com.pravin.cryptocompose.data.remote.CoinApi
import com.pravin.cryptocompose.data.repository.CoinRepository
import com.pravin.cryptocompose.domain.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesHttpInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor(
        HttpLoggingInterceptor.Logger.DEFAULT
    ).apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun providesOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Provides
    @Singleton
    fun providesCoinAPi(httpClient: OkHttpClient): CoinApi =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient)
            .build().create(CoinApi::class.java)

    @Provides
    @Singleton
    fun providesCoinRepository(coinAPi: CoinApi): CoinRepository = CoinRepositoryImpl(coinAPi)


}