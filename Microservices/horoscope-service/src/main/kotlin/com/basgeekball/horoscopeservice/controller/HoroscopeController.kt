package com.basgeekball.horoscopeservice.controller

import com.basgeekball.horoscopeservice.Horoscope
import com.basgeekball.horoscopeservice.client.UserClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HoroscopeController() {
    @Autowired
    private lateinit var userClient: UserClient

    @GetMapping("/fortune")
    fun fortune(): String {
        val user = userClient.getUsers().content.random()
        val zodiacSign = Horoscope.tellZodiacSign(user.dob)
        return "${user.name} who was born on ${user.dob}, her/his zodiac sign is ${zodiacSign!!.symbol()}."
    }
}