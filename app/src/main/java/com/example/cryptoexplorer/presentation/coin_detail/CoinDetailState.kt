package com.example.cryptoexplorer.presentation.coin_detail

import com.example.cryptoexplorer.domain.model.CoinDetailModel
import com.example.cryptoexplorer.domain.model.CoinModel

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetailModel? = null,
    val error : String = ""
)
