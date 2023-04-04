package com.refrence.cryptocurrencapp.data.repositories

import com.refrence.cryptocurrencapp.data.remote.CoinPaprikaApi
import com.refrence.cryptocurrencapp.data.remote.dto.CoinDetailDto
import com.refrence.cryptocurrencapp.data.remote.dto.CoinDto
import com.refrence.cryptocurrencapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}