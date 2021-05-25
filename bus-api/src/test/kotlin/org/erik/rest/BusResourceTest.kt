package org.erik.rest

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.erik.WireMock
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
@QuarkusTestResource(WireMock::class)
class BusResourceTest {

    @Test
    fun getBusLines_trafiklabReturnsLines_topTenLinesAreReturned() {

        val expectedBusLinesResult = this::class.java.classLoader.getResource("rest/busLinesResult.json").readText()
        given()
                .`when`().get("/bus-lines")
                .then()
                .statusCode(200)
                .body(`is`(expectedBusLinesResult))

    }

}