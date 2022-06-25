package com.pravin.cryptocompose.data.remote

import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.data.remote.dto.CryptoCoinDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getAllCoins():List<CryptoCoin>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId:String):CryptoCoinDetails
}