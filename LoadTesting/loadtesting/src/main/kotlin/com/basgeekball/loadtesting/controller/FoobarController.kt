package com.basgeekball.loadtesting.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FoobarController {
    @GetMapping(value = ["/foobar"])
    fun foobar(): ResponseEntity<String> {
        return ResponseEntity(listOf("Foobar", "Foo", "Bar").random(), HttpStatus.OK)
    }

    @GetMapping(value = ["/foo"])
    fun foo(): ResponseEntity<String> {
        return ResponseEntity("foo", HttpStatus.OK)
    }

    @GetMapping(value = ["/bar"])
    fun bar(): ResponseEntity<String> {
        return ResponseEntity("bar", HttpStatus.OK)
    }
}