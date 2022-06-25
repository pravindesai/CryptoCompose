package com.pravin.cryptocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pravin.cryptocompose.common.Constants
import com.pravin.cryptocompose.ui.coin_details.CoinDetailsViewModel
import com.pravin.cryptocompose.ui.coin_list.CoinListViewModel
import com.pravin.cryptocompose.ui.components.CoinDetailsScreen
import com.pravin.cryptocompose.ui.components.CoinListScreen
import com.pravin.cryptocompose.ui.screens.Screen
import com.pravin.cryptocompose.ui.theme.CryptoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

// https://api.coinpaprika.com/v1/coins/
// https://api.coinpaprika.com/v1/coins/{id}
// https://www.youtube.com/watch?v=EF33KmyprEQ

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }

                        composable(route = Screen.CoinDetailsScreen.route + "/{${Constants.PARAM_COIN_ID}}") {
                            CoinDetailsScreen()
                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoComposeTheme {

    }
}