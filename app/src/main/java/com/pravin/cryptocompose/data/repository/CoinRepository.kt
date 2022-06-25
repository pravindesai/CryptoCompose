package com.pravin.cryptocompose.data.repository

import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.data.remote.dto.CryptoCoinDetails

interface CoinRepository {
    suspend fun getAllCoins():List<CryptoCoin>
    suspend fun getCoin(coinId:String):CryptoCoinDetails
}