package com.basgeekball.horoscopeservice.controller

import com.basgeekball.horoscopeservice.Horoscope
import com.basgeekball.horoscopeservice.client.UserClient
import com.basgeekball.horoscopeservice.model.Divination
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.util.*

@RestController
class HoroscopeController {
    @Autowired
    private lateinit var userClient: UserClient
    private val mapper = jacksonObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

    @GetMapping(value = ["/fortune"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @CircuitBreaker(name = "horoscopeService", fallbackMethod = "fallback")
    fun fortune(): ResponseEntity<String> {
        val user = userClient.getUsers().content.random()
        val zodiacSign = Horoscope.tellZodiacSign(user.dob)
        val response = mapper.writeValueAsString(Divination(user.name, user.dob, Divination.ZodiacSign(zodiacSign!!.name, zodiacSign.symbol())))
        return ResponseEntity.ok(response)
    }

    @Suppress("unused")
    fun fallback(e: Exception): ResponseEntity<String> {
        val response = mapper.writeValueAsString(Divination("John Doe", Date(), Divination.ZodiacSign("", "")))
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}