package com.pravin.cryptocompose.ui.coin_details

import com.pravin.cryptocompose.data.remote.dto.CryptoCoinDetails


data class CoinDetailState(
    val isLoading:Boolean = false,
    val coinDetails:CryptoCoinDetails? = null,
    val error:String = ""
)