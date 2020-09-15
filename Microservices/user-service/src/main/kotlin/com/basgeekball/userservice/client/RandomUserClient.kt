package com.basgeekball.userservice.client

import com.basgeekball.userservice.entity.domain.randomuser.RandomUser
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class RandomUserClient {
    companion object {
        const val BASE_URL = "https://randomuser.me/api"
    }

    private val client = WebClientBuilderWrapper.form(BASE_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()

    private fun retrieveResponse(request: WebClient.RequestBodySpec) : RandomUser? {
        return request.retrieve()
                .bodyToMono(RandomUser::class.java)
                .block()
    }

    fun getRandomUser() : RandomUser? {
        val request = client.method(HttpMethod.GET)
        return retrieveResponse(request)
    }

    fun getRandomUsers(amount: Int) : RandomUser? {
        val request = client.method(HttpMethod.GET).uri("/?results=$amount")
        return retrieveResponse(request)
    }

    fun getRandomUser(seed: String) : RandomUser? {
        val request = client.method(HttpMethod.GET).uri("/?seed=$seed")
        return retrieveResponse(request)
    }
}