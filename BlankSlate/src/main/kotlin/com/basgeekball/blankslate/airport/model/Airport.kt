package com.basgeekball.blankslate.airport.model

import java.time.Month

data class Airport(
    val iata: String,
    val icao: String?,
    val name: String,
    val location: String,
    val timezone: String?,
    val dst: Pair<Month, Month>?
)
