package com.basgeekball.blankslate

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DecisionController {
    @GetMapping("/decision")
    fun decision(): String {
        val idx = (0..1).random()
        return Decision.getByValue(idx)!!.name
    }
}