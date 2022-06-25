package com.pravin.cryptocompose.domain.use_cases.get_coin

import com.pravin.cryptocompose.common.Resources
import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.data.remote.dto.CryptoCoinDetails
import com.pravin.cryptocompose.data.repository.CoinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resources<CryptoCoinDetails>> = flow {
        try {
            emit(Resources.Loading())
            val coin  = coinRepository.getCoin(coinId)
            emit(Resources.Success(coin))
        }catch (e:Exception){
            emit(Resources.Error(e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)
}