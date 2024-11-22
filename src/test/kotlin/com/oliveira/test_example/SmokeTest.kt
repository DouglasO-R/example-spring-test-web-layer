package com.oliveira.test_example

import com.oliveira.test_example.controller.HomeController
import org.assertj.core.api.Assertions.assertThat


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Test

@SpringBootTest
class SmokeTest {

    @Autowired
    lateinit var controller: HomeController

    @Test
    fun contextLoad() {
        assertThat(controller).isNotNull()
    }
}