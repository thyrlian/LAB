package com.basgeekball.horoscopeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoroscopeServiceApplication

fun main(args: Array<String>) {
	runApplication<HoroscopeServiceApplication>(*args)
}
