package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Picture(
        @JsonProperty("large") val large: String,
        @JsonProperty("medium") val medium: String,
        @JsonProperty("thumbnail") val thumbnail: String
)