package com.example.backend.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RenderController {
    @GetMapping(path = ["/"])
    fun render(): String {
        return "/index.html"
    }
}