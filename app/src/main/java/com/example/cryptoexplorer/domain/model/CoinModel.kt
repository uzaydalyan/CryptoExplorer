package com.example.cryptoexplorer.domain.model

data class CoinModel(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
