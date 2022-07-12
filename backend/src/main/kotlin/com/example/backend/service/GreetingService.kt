package com.example.backend.service

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun hello(): String {
        return "\"Welcome! This is boilerplate of springboot + kotlin + CRA\""
    }
}