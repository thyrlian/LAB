package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Info(
        @JsonProperty("seed") val seed: String,
        @JsonProperty("results") val results: Int,
        @JsonProperty("page") val page: Int,
        @JsonProperty("version") val version: String
)