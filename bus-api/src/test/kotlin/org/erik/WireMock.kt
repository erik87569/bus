package org.erik

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import com.github.tomakehurst.wiremock.WireMockServer

import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.client.WireMock.*


class WireMock: QuarkusTestResourceLifecycleManager {

    private lateinit var wireMockServer: WireMockServer

    override fun start(): Map<String, String> {
        wireMockServer = WireMockServer(WireMockConfiguration.options().dynamicPort())
        wireMockServer.start()

        val jourResponse = this::class.java.classLoader.getResource("rest/jourResponse.json").readText()

        wireMockServer.stubFor(get(urlEqualTo("/%3Fmodel=jour&key=abe30ab933fa4dd99f53d16a9c4fd062&DefaultTransportModeCode=BUS"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                jourResponse
                        )))

        val lineResponse = this::class.java.classLoader.getResource("rest/lineResponse.json").readText()

        wireMockServer.stubFor(get(urlEqualTo("/%3Fmodel=line&key=abe30ab933fa4dd99f53d16a9c4fd062&DefaultTransportModeCode=BUS"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(
                                lineResponse
                        )))

        return mapOf("bus-api/mp-rest/url" to wireMockServer.baseUrl())
    }

    override fun stop() {
        if (null != wireMockServer) {
            wireMockServer.stop()
        }
    }


}