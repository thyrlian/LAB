package com.basgeekball.loadtesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoadTestingApplication

fun main(args: Array<String>) {
	runApplication<LoadTestingApplication>(*args)
}
