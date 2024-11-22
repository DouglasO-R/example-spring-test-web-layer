package com.oliveira.test_example.controller

import com.oliveira.test_example.service.GreetingService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(val service: GreetingService) {

    @RequestMapping("/greeting")
    fun greeting(): String {
        return service.greet()
    }
}