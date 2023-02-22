package com.example.cryptoexplorer.data.repository

import com.example.cryptoexplorer.data.remote.CoinPaprikaApi
import com.example.cryptoexplorer.data.remote.dto.CoinDTO
import com.example.cryptoexplorer.data.remote.dto.CoinDetailDTO
import com.example.cryptoexplorer.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinByyId(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}