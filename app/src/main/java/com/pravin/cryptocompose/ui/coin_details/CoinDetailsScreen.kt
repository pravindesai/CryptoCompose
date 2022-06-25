package com.pravin.cryptocompose.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.google.accompanist.flowlayout.FlowRow
import com.pravin.cryptocompose.common.Constants
import com.pravin.cryptocompose.ui.coin_details.CoinDetailsViewModel
import com.pravin.cryptocompose.ui.coin_list.CoinListViewModel
import com.pravin.cryptocompose.ui.screens.Screen


@Composable
fun CoinDetailsScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.coinDetailState.value

    Box(modifier = Modifier.fillMaxSize()) {

        state.coinDetails?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "${coin.rank}",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = "${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = if (coin.isActive == true) "Active" else "InActive",
                            color = if (coin.isActive == true) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                        )


                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = coin.description ?: "", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.titleMedium
                    )

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
                    ) {
                        coin.tags?.forEach { tag->
                            tag?.name?.let{
                                CoinTag(it)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                }

                items(coin.team?: emptyList()){ teamMember->
                    teamMember?.let {
                        TeamListItem(teamMember = it, modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp))
                        Divider(modifier = Modifier.padding(top = 5.dp, bottom = 10.dp))
                    }
                }

            }

        }


        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}