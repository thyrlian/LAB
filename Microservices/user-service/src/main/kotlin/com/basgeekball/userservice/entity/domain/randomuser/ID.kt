package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ID(
        @JsonProperty("name") val name: String,
        @JsonProperty("value") val value: String?
)