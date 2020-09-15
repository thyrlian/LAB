package com.basgeekball.userservice.util

import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import reactor.core.publisher.Mono
import java.util.function.Consumer

class LogFilter {
    companion object {
        private val logger by LoggerDelegate()

        fun logRequest(): ExchangeFilterFunction {
            return ExchangeFilterFunction.ofRequestProcessor { clientRequest ->
                logger.debug("==================================================")
                logger.debug("Request: {} {}", clientRequest.method(), clientRequest.url())
                if (clientRequest.headers().isNotEmpty()) {
                    logger.debug("Request Headers:")
                    clientRequest.headers().forEach { name: String?, values: List<String?> ->
                        values.forEach( Consumer {
                            value: String? -> logger.debug("$name: $value")
                        })
                    }
                }
                logger.debug("==================================================")
                Mono.just(clientRequest)
            }
        }

        fun logResponse(): ExchangeFilterFunction {
            return ExchangeFilterFunction.ofResponseProcessor { clientResponse ->
                logger.debug("Response: {} {}", clientResponse.statusCode(), clientResponse.bodyToMono(String::class.java))
                Mono.just(clientResponse)
            }
        }
    }
}