package com.pravin.cryptocompose.ui.coin_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pravin.cryptocompose.common.Resources
import com.pravin.cryptocompose.data.remote.dto.CryptoCoin
import com.pravin.cryptocompose.domain.use_cases.get_coin.GetCoinUseCase
import com.pravin.cryptocompose.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _coinListState:MutableState<CoinListState> = mutableStateOf(CoinListState())
    val coinListState:State<CoinListState> = _coinListState

    init {
        getCoins()
    }

    fun getCoins() =
        viewModelScope.launch {
            getCoinsUseCase().collectLatest { result ->
                Log.e("**", "getCoins: $result")
                when(result){
                    is Resources.Success ->{
                        Log.e("**", "getCoins: Success" )
                        _coinListState.value = CoinListState(coins = result.data ?: emptyList())
                    }
                    is Resources.Loading ->{
                        Log.e("**", "getCoins: Loading" )
                        _coinListState.value = CoinListState(isLoading = true)
                    }
                    is Resources.Error->{
                        Log.e("**", "getCoins: Error" )
                        _coinListState.value = CoinListState(
                            error = result.message ?: "An unexpected Error Occurred"
                        )
                    }
                }
            }
        }

}