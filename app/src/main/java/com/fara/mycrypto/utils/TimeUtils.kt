package com.fara.mycrypto.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimeStampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val stamp = Timestamp(timestamp * AppConstants.SECOND_IN_MILLISECOND)
    val date = Date(stamp.time)
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}