package com.basgeekball.userservice.client

import com.basgeekball.userservice.util.LogFilter
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

class WebClientBuilderWrapper {
    companion object {
        fun form(baseUrl: String): WebClient.Builder {
            return WebClient.builder()
                    .baseUrl(baseUrl)
                    .exchangeStrategies(ExchangeStrategies.builder().codecs { configurer ->
                        configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)
                    }.build())
                    .filters { exchangeFilterFunctions ->
                        exchangeFilterFunctions.add(LogFilter.logRequest())
                        exchangeFilterFunctions.add(LogFilter.logResponse())
                    }
        }
    }
}