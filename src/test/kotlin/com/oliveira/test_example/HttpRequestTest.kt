package com.oliveira.test_example

import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import kotlin.test.Test

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {
    @LocalServerPort
    var port: Int? = null

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun greetingShouldReturnDefaultMessage(){
        assertThat(
            restTemplate.getForObject(
                "http://localhost:$port/",
                String::class.java
            )
        ).contains("ola mundo")
    }
}