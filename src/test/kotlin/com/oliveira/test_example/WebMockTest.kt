package com.oliveira.test_example

import com.oliveira.test_example.controller.GreetingController
import com.oliveira.test_example.service.GreetingService
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(GreetingController::class)
class WebMockTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: GreetingService

    @Test
    fun greTingShouldReturnMessageFromService() {
        `when`(service.greet()).thenReturn("Ola mundo")
        mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk)
            .andExpect(content().string(containsString("Ola mundo")))
    }
}