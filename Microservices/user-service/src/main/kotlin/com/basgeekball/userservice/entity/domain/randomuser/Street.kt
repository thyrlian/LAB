package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Street(
        @JsonProperty("number") val number: String,
        @JsonProperty("name") val name: String
)