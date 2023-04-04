package com.refrence.cryptocurrencapp.domain.repository

import com.refrence.cryptocurrencapp.data.remote.dto.CoinDetailDto
import com.refrence.cryptocurrencapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinsById(coinId : String):CoinDetailDto
}