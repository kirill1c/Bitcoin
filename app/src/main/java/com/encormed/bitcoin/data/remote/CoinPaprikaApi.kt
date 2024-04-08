package com.encormed.bitcoin.data.remote

import android.adservices.adid.AdId
import com.encormed.bitcoin.data.remote.dto.CoinDetailDto
import com.encormed.bitcoin.data.remote.dto.CoinDto
import com.encormed.bitcoin.domain.model.Coin
import com.encormed.bitcoin.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}