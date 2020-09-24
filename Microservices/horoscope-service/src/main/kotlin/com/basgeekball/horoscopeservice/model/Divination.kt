package com.basgeekball.horoscopeservice.model

import java.util.*

data class Divination(
        val name: String,
        val dob: Date,
        val zodiacSign: ZodiacSign
) {
    data class ZodiacSign(
            val name: String,
            val symbol: String
    )
}