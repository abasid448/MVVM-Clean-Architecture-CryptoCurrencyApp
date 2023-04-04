package com.refrence.cryptocurrencapp.domain.use_case.get_coins

import com.refrence.cryptocurrencapp.common.Resource
import com.refrence.cryptocurrencapp.data.remote.dto.toCoin
import com.refrence.cryptocurrencapp.domain.model.Coin
import com.refrence.cryptocurrencapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unExpected error occured"))

        } catch (e: IOException) {

            emit(Resource.Error("check your internet Connection"))

        }
    }
}