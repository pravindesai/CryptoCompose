package com.pravin.cryptocompose.domain.use_cases.get_coins

import com.pravin.cryptocompose.common.Resources
import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.data.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(): Flow<Resources<List<CryptoCoin>>> = flow {
            try {
                emit(Resources.Loading())
                val coin = coinRepository.getAllCoins()
                emit(Resources.Success(coin))
            } catch (e: Exception) {
                emit(Resources.Error(e.localizedMessage))
            }
    }.flowOn(Dispatchers.IO)
}