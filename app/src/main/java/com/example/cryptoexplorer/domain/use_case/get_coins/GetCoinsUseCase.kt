package com.example.cryptoexplorer.domain.use_case.get_coins

import com.example.cryptoexplorer.data.remote.dto.toCoinModel
import com.example.cryptoexplorer.domain.model.CoinModel
import com.example.cryptoexplorer.domain.repository.CoinRepository
import com.example.cryptoexplorer.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<CoinModel>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {it.toCoinModel()}
            emit(Resource.Success(coins))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An error has occured!"))
        } catch (e : IOException){
            emit(Resource.Error("Couldn't reach server! Please check your internet connection."))
        }
    }

}