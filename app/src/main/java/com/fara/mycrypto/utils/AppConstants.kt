package com.fara.mycrypto.utils

class AppConstants {

    companion object {
        const val BASE_URL = "https://min-api.cryptocompare.com/data/"
        const val BASE_IMAGE_URL = "https://cryptocompare.com"

        const val QUERY_PARAM_API_KEY = "api_key"
        const val QUERY_PARAM_LIMIT = "limit"
        const val QUERY_PARAM_TO_SYMBOL = "tsym"
        const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        const val API_KEY =
            "dd7c589f30dccee565873df6fc52232ef4337e5141ac223b9f5aa9255278168a"
        const val CURRENCY = "USD"

        const val BASE_LIMIT_OF_SYMBOLS = 50

        const val SECOND_IN_MILLISECOND = 1000

        const val BASE_DELAY_OF_REPEAT_REQUEST = 10

        const val EXTRA_FROM_SYMBOL = "fSym"
    }
}