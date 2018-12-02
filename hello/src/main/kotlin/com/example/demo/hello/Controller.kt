package com.example.demo.hello

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @Value("\${hoge}")
    private val hoge: String? = null

    @Value("\${fuga}")
    private val fuga: String? = null

    @GetMapping("/hello")
    fun hello(
        @RequestParam(required = false, defaultValue = "world") name: String
    ): String {
        return "hello $name"
    }

    @GetMapping("/test")
    fun test(): String {
        return "$hoge $fuga"
    }
}
