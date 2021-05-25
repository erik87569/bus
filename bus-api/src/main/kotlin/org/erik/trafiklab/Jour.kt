package org.erik.trafiklab

import com.fasterxml.jackson.annotation.JsonProperty

data class Jour(
    @JsonProperty("LineNumber")
    val lineNumber: Int,
    @JsonProperty("JourneyPatternPointNumber")
    val journeyPatternPointNumber: Int
)