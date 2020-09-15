package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Name(
        @JsonProperty("title") val title: String,
        @JsonProperty("first") val first: String,
        @JsonProperty("last") val last: String
)