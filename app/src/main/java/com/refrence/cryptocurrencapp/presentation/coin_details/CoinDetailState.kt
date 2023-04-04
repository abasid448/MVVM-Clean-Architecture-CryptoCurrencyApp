package com.refrence.cryptocurrencapp.presentation.coin_details

import com.refrence.cryptocurrencapp.domain.model.Coin
import com.refrence.cryptocurrencapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin: CoinDetail ?= null,
    val error:String = ""
)
