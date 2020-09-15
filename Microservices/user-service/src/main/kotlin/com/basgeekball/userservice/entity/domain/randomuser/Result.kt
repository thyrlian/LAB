package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Result(
        @JsonProperty("gender") val gender: String,
        @JsonProperty("name") val name: Name,
        @JsonProperty("location") val location: Location,
        @JsonProperty("email") val email: String,
        @JsonProperty("login") val login: Login,
        @JsonProperty("dob") val dob: DOB,
        @JsonProperty("registered") val registered: Registered,
        @JsonProperty("phone") val phone: String,
        @JsonProperty("cell") val cell: String,
        @JsonProperty("id") val id: ID,
        @JsonProperty("picture") val picture: Picture,
        @JsonProperty("nat") val nat: String
)