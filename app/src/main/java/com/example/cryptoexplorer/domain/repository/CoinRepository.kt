package com.example.cryptoexplorer.domain.repository

import com.example.cryptoexplorer.data.remote.dto.CoinDTO
import com.example.cryptoexplorer.data.remote.dto.CoinDetailDTO

interface CoinRepository {

    suspend fun getCoins() : List<CoinDTO>

    suspend fun getCoinById(coinId : String) : CoinDetailDTO
}