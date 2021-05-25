package org.erik.trafiklab

import com.fasterxml.jackson.annotation.JsonProperty

data class Response<T>(
    @JsonProperty("StatusCode")
    val statusCode: Int,
    @JsonProperty("ExecutionTime")
    val executionTime: Int,
    @JsonProperty("ResponseData")
    val responseData: ResponseData<T>
)