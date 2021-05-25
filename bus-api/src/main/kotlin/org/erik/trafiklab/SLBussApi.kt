package org.erik.trafiklab

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "bus-api")
interface SLBussApi {
    @GET
    @Path("?model=jour&key=abe30ab933fa4dd99f53d16a9c4fd062&DefaultTransportModeCode=BUS")
    fun getJour(): Response<Jour>
}