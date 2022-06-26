package com.pravin.cryptocompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pravin.cryptocompose.ui.coin_list.CoinListViewModel
import com.pravin.cryptocompose.ui.screens.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
    ) {
    val state = viewModel.coinListState.value
    
    val textValue:MutableState<String> = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = { SearchView(textValue = textValue) },
        content = { contentPadding->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)){
                LazyColumn(modifier = Modifier.fillMaxSize()){
             val filteredList = state.coins.filter { it.name?.contains(textValue.value)?:true }

                    items( filteredList ){coin->
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
    )
}


