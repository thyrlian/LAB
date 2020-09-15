package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Coordinates(
        @JsonProperty("latitude") val latitude: String,
        @JsonProperty("longitude") val longitude: String
)