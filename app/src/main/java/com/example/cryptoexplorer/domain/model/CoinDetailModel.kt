package com.example.cryptoexplorer.domain.model

import com.example.cryptoexplorer.data.remote.dto.TeamMember

data class CoinDetailModel(
    val coinId : String,
    val name : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags : List<String>,
    val team : List<TeamMember>
)
