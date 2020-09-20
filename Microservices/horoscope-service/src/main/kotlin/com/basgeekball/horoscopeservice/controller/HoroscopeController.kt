package com.basgeekball.horoscopeservice.controller

import com.basgeekball.horoscopeservice.Horoscope
import com.basgeekball.horoscopeservice.client.UserClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

@RestController
class HoroscopeController {
    @Autowired
    private lateinit var userClient: UserClient

    @GetMapping(value = ["/fortune"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @CircuitBreaker(name = "horoscopeService", fallbackMethod = "fallback")
    fun fortune(): ResponseEntity<String> {
        val user = userClient.getUsers().content.random()
        val zodiacSign = Horoscope.tellZodiacSign(user.dob)
        val response = "{\"name\": \"${user.name}\", \"dob\": \"${user.dob}\", \"zodiacSign\": {\"name\": \"${zodiacSign!!.name}\", \"symbol\": \"${zodiacSign.symbol()}\"}}"
        return ResponseEntity.ok(response)
    }

    @Suppress("unused")
    fun fallback(e: Exception): ResponseEntity<String> {
        val response = "{\"name\": \"\", \"dob\": \"\", \"zodiacSign\": {\"name\": \"\", \"symbol\": \"\"}}"
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}