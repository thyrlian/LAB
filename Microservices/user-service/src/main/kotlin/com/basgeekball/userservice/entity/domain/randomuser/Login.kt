package com.basgeekball.userservice.entity.domain.randomuser

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Login(
        @JsonProperty("uuid") val uuid: String,
        @JsonProperty("username") val username: String,
        @JsonProperty("password") val password: String,
        @JsonProperty("salt") val salt: String,
        @JsonProperty("md5") val md5: String,
        @JsonProperty("sha1") val sha1: String,
        @JsonProperty("sha256") val sha256: String
)