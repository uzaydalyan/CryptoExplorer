package com.example.cryptoexplorer.presentation.coin_list

import com.example.cryptoexplorer.domain.model.CoinModel

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<CoinModel> = emptyList(),
    val error : String = ""
)
