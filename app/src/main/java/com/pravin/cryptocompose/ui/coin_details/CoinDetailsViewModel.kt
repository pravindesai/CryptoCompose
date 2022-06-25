package com.pravin.cryptocompose.ui.coin_details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pravin.cryptocompose.common.Constants.PARAM_COIN_ID
import com.pravin.cryptocompose.common.Resources
import com.pravin.cryptocompose.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _coinDetailState:MutableState<CoinDetailState> = mutableStateOf(CoinDetailState())
    val coinDetailState:State<CoinDetailState> = _coinDetailState

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {  cId->
            Log.e("**", "getCoin:Details "+cId )
            getCoin(coinId = cId) }
    }

    private fun getCoin(coinId:String)  = viewModelScope.launch {

        Log.e("**", "getCoin:Details "+coinId )

        getCoinUseCase(coinId).collectLatest { result ->
            Log.e("**", "getCoin: $result")
            when(result){
                is Resources.Success ->{
                    _coinDetailState.value = CoinDetailState( coinDetails = result.data)
                }
                is Resources.Loading ->{
                    _coinDetailState.value = CoinDetailState(isLoading = true)
                }
                is Resources.Error->{
                    _coinDetailState.value = CoinDetailState(
                        error = result.message ?: "An unexpected Error Occurred"
                    )
                }
            }
        }
    }

}