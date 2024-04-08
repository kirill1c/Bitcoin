package com.encormed.bitcoin.data.repository

import com.encormed.bitcoin.data.remote.CoinPaprikaApi
import com.encormed.bitcoin.data.remote.dto.CoinDetailDto
import com.encormed.bitcoin.data.remote.dto.CoinDto
import com.encormed.bitcoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}