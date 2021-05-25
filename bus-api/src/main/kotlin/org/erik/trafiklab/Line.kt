package org.erik.trafiklab

import com.fasterxml.jackson.annotation.JsonProperty

data class Line(
    @JsonProperty("LineNumber")
    val lineNumber: Int,
    @JsonProperty("LineDesignation")
    val lineDesignation: String
)
