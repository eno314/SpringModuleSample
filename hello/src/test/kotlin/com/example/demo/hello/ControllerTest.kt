package com.example.demo.hello

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest
class ControllerTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun test() {
        // /hello に リクエストパラメータ name=test を付与してリクエストすると、
        // ステータスが200でレスポンスが"hello test" になることを確認する
        val request = MockMvcRequestBuilders.get("/hello")
            .param("name", "test")
        mockMvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("hello test"))
    }

    @SpringBootApplication
    internal class TestConfiguration
}
