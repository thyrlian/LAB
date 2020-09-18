package com.basgeekball.horoscopeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.hateoas.config.EnableHypermediaSupport

@EnableDiscoveryClient
@EnableFeignClients
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
@SpringBootApplication
class HoroscopeServiceApplication

fun main(args: Array<String>) {
	runApplication<HoroscopeServiceApplication>(*args)
}
