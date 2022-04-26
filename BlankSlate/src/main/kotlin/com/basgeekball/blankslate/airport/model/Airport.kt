package com.basgeekball.blankslate.airport.model

data class Airport(
    val iata: String,
    val icao: String,
    val name: String,
    val location: String,
    val time: String,
    val dst: String
)
