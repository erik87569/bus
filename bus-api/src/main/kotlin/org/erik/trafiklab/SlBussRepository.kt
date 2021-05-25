package org.erik.trafiklab

import org.eclipse.microprofile.rest.client.inject.RestClient
import org.erik.core.BussRepository
import org.erik.core.LineStopPointMapping
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class SlBussRepository : BussRepository {

    @Inject
    @field: RestClient
    internal lateinit var api: SLBussApi

    override fun getLineStopPointMappings(): List<LineStopPointMapping> {
        val response = api.getJour()
        return response.responseData.result
            .map { j -> toLineStopPointMapping(j) }
    }

    private fun toLineStopPointMapping(j: Jour): LineStopPointMapping {
        return LineStopPointMapping(
            lineNumber = j.lineNumber,
            stopPointNumber = j.journeyPatternPointNumber
        )
    }
}