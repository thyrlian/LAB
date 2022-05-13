package com.basgeekball.blankslate.airport.controller

import com.basgeekball.blankslate.airport.misc.AirportFactory
import com.basgeekball.blankslate.airport.model.Airport
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class AirportController {
    companion object {
        val airports = AirportFactory.build()
    }

    @GetMapping("/airports")
    fun airports(): ResponseEntity<ArrayList<Airport>> {
        return ResponseEntity(airports, HttpStatus.OK)
    }

    @GetMapping("/airports/{iata}")
    fun airport(@PathVariable iata: String): ResponseEntity<out Airport> {
        val airport = airports.firstOrNull { it.iata.equals(iata) }
        return if (airport != null) {
            ResponseEntity(airport, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}