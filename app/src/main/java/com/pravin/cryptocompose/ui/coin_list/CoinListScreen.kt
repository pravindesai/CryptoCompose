package com.pravin.cryptocompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.pravin.cryptocompose.ui.coin_list.CoinListViewModel
import com.pravin.cryptocompose.ui.screens.Screen


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
    ) {
    val state = viewModel.coinListState.value

    Box(modifier = Modifier.fillMaxSize()){
         LazyColumn(modifier = Modifier.fillMaxSize()){
             items(state.coins){coin->
                 CoinListItem(coin = coin,
                     onItemClick = {
                         navController.navigate(Screen.CoinDetailsScreen.route+"/${coin.id}")
                    }
                 )
             }
         }
        if (state.error.isNotBlank()){
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.Center))
        }

        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}