package com.basgeekball.horoscopeservice.controller

import com.basgeekball.horoscopeservice.Horoscope
import com.basgeekball.horoscopeservice.client.UserClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HoroscopeController() {
    @Autowired
    private lateinit var userClient: UserClient

    @GetMapping(value = ["/fortune"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fortune(): ResponseEntity<String> {
        val user = userClient.getUsers().content.random()
        val zodiacSign = Horoscope.tellZodiacSign(user.dob)
        return ResponseEntity.ok("{\"name\": \"${user.name}\", \"dob\": \"${user.dob}\", \"zodiacSign\": {\"name\": \"${zodiacSign!!.name}\", \"symbol\": \"${zodiacSign!!.symbol()}\"}}")
    }
}