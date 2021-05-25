package org.erik.trafiklab

import com.fasterxml.jackson.annotation.JsonProperty

data class ResponseData<T>(
    @JsonProperty("Version")
    val version: String,
    @JsonProperty("Type")
    val type: String,
    @JsonProperty("Result")
    val result: List<T>
)
