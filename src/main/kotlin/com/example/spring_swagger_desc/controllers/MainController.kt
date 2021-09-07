package com.example.spring_swagger_desc.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/", "/index")
    fun index(): ResponseEntity<String> {
        return ResponseEntity("Index!!!!", HttpStatus.OK)
    }
}