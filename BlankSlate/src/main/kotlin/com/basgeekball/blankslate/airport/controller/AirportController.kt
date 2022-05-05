package com.basgeekball.blankslate.airport.controller

import com.basgeekball.blankslate.airport.misc.AirportFactory
import com.basgeekball.blankslate.airport.model.Airport
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AirportController {
    companion object {
        val airports = AirportFactory.build()
    }

    @GetMapping("/airports")
    fun airports(): ArrayList<Airport> {
        return airports
    }

    @GetMapping("/airports/{iata}")
    fun airport(@PathVariable iata: String): Airport? {
        return airports.firstOrNull { it.iata.equals(iata) }
    }
}