package com.basgeekball.loadtesting.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger
import java.security.MessageDigest
import java.util.zip.CRC32


@RestController
class HeavyliftController {
    private val crc = CRC32()
    private val md = MessageDigest.getInstance("SHA-512")

    @GetMapping(value = ["/checksum"])
    fun checksum(@RequestParam data: String): ResponseEntity<Long> {
        crc.reset()
        crc.update(data.toByteArray(Charsets.UTF_8))
        return ResponseEntity(crc.value, HttpStatus.OK)
    }

    @GetMapping(value = ["/hash"])
    fun hash(@RequestParam password: String): ResponseEntity<String> {
        val messageDigest = md.digest(password.toByteArray(Charsets.UTF_8))
        val hash = BigInteger(1, messageDigest).toString(16).padStart(32, '0')
        return ResponseEntity(hash, HttpStatus.OK)
    }
}