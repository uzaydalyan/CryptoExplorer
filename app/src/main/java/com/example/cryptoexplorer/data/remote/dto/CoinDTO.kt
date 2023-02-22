package com.example.cryptoexplorer.data.remote.dto

import com.example.cryptoexplorer.domain.model.CoinModel

data class CoinDTO(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String,
)

fun CoinDTO.toCoinModel() : CoinModel{
    return CoinModel(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}