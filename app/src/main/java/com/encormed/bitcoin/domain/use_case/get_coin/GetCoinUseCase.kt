package com.encormed.bitcoin.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.encormed.bitcoin.common.Resource
import com.encormed.bitcoin.data.remote.dto.toCoin
import com.encormed.bitcoin.data.remote.dto.toCoinDetail
import com.encormed.bitcoin.domain.model.Coin
import com.encormed.bitcoin.domain.model.CoinDetail
import com.encormed.bitcoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка."))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "Не удалось связаться с сервером. Проверьте интернет соединение."))
        }
    }
}