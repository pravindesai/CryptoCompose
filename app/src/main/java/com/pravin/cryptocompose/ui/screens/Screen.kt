package com.pravin.cryptocompose.ui.screens

sealed class Screen(val route:String){
    object CoinListScreen:Screen("coinlist")
    object CoinDetailsScreen:Screen("coindetails")
}
