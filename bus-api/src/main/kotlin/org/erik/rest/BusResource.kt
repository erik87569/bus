package org.erik.rest

import org.erik.core.BusLine
import org.erik.core.BusService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bus-lines")
class BusResource {

    @Inject
    @field: Default
    internal lateinit var service: BusService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getBusLines(): List<BusLine> = service.getLines()
}