package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Location(
        @JsonProperty("street") val street: Street,
        @JsonProperty("city") val city: String,
        @JsonProperty("state") val state: String,
        @JsonProperty("country") val country: String,
        @JsonProperty("postcode") val postcode: String,
        @JsonProperty("coordinates") val coordinates: Coordinates,
        @JsonProperty("timezone") val timezone: Timezone
)