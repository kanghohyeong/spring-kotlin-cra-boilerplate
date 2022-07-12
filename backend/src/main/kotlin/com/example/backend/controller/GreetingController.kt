package com.example.backend.controller

import com.example.backend.service.GreetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class GreetingController(
    private val greetingService: GreetingService
) {
    @GetMapping("/greeting")
    fun hello(): String {
        return greetingService.hello()
    }
}