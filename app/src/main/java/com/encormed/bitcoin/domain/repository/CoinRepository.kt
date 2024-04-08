package com.encormed.bitcoin.domain.repository

import com.encormed.bitcoin.data.remote.dto.CoinDetailDto
import com.encormed.bitcoin.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}