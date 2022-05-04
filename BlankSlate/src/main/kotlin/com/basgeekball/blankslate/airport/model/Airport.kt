package com.basgeekball.blankslate.airport.model

import java.time.Month
import java.time.ZoneOffset

data class Airport(
    val iata: String,
    val icao: String?,
    val name: String,
    val location: String,
    val timezone: ZoneOffset?,
    val dst: Pair<Month, Month>?
)
