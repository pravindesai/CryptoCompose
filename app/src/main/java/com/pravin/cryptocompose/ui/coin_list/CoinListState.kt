package com.pravin.cryptocompose.ui.coin_list

import com.pravin.cryptocompose.data.remote.dto.CryptoCoin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins:List<CryptoCoin> = emptyList(),
    val error:String = ""
)