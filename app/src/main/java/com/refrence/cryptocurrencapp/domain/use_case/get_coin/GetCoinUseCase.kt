package com.refrence.cryptocurrencapp.domain.use_case.get_coin

import com.refrence.cryptocurrencapp.common.Resource
import com.refrence.cryptocurrencapp.data.remote.dto.toCoin
import com.refrence.cryptocurrencapp.data.remote.dto.toCoinDetail
import com.refrence.cryptocurrencapp.domain.model.Coin
import com.refrence.cryptocurrencapp.domain.model.CoinDetail
import com.refrence.cryptocurrencapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinsById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unExpected error occured"))

        } catch (e: IOException) {

            emit(Resource.Error("check your internet Connection"))

        }
    }
}