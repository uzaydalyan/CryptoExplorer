package com.example.cryptoexplorer.domain.use_case.get_coin_detail

import com.example.cryptoexplorer.data.remote.dto.toCoinDetailModel
import com.example.cryptoexplorer.domain.model.CoinDetailModel
import com.example.cryptoexplorer.domain.repository.CoinRepository
import com.example.cryptoexplorer.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetailModel>> = flow{
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetailModel()
            emit(Resource.Success(coin))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An error has occured!"))
        } catch (e : IOException){
            emit(Resource.Error("Couldn't reach server! Please check your internet connection."))
        }
    }

}