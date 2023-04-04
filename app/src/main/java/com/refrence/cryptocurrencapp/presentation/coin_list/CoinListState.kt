package com.refrence.cryptocurrencapp.presentation.coin_list

import com.refrence.cryptocurrencapp.domain.model.Coin

data class CoinListState(
    val isLoading:Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error:String = ""
)
