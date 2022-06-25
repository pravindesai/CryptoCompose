package com.pravin.cryptocompose.domain.repository

import com.pravin.cryptocompose.data.remote.CoinApi
import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.data.remote.dto.CryptoCoinDetails
import com.pravin.cryptocompose.data.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinApi
):CoinRepository {
    override suspend fun getAllCoins(): List<CryptoCoin> {
        return api.getAllCoins()
    }

    override suspend fun getCoin(coinId: String): CryptoCoinDetails {
        return api.getCoin(coinId)
    }
}