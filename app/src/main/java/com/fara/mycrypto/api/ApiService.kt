package com.fara.mycrypto.api

import com.fara.mycrypto.pojo.CoinInfoListOfData
import com.fara.mycrypto.pojo.CoinPriceInfoRawData
import com.fara.mycrypto.utils.AppConstants.Companion.API_KEY
import com.fara.mycrypto.utils.AppConstants.Companion.BASE_LIMIT_OF_SYMBOLS
import com.fara.mycrypto.utils.AppConstants.Companion.CURRENCY
import com.fara.mycrypto.utils.AppConstants.Companion.QUERY_PARAM_API_KEY
import com.fara.mycrypto.utils.AppConstants.Companion.QUERY_PARAM_FROM_SYMBOLS
import com.fara.mycrypto.utils.AppConstants.Companion.QUERY_PARAM_LIMIT
import com.fara.mycrypto.utils.AppConstants.Companion.QUERY_PARAM_TO_SYMBOL
import com.fara.mycrypto.utils.AppConstants.Companion.QUERY_PARAM_TO_SYMBOLS
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int = BASE_LIMIT_OF_SYMBOLS,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY,
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY,
    ): Single<CoinPriceInfoRawData>
}