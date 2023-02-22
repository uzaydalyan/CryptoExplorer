package com.example.cryptoexplorer.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoexplorer.domain.model.CoinModel
import com.example.cryptoexplorer.domain.use_case.get_coin_detail.GetCoinDetailUseCase
import com.example.cryptoexplorer.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptoexplorer.util.Constants
import com.example.cryptoexplorer.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init{
        savedStateHandle.get<String>(Constants.VAR_COIN_ID)?.let { coinId ->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(coinId : String){
        getCoinDetailUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "An error has occured!")
                }

                is Resource.Loading -> {

                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}