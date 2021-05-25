package org.erik.core

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class BusService(@Inject val repository: BussRepository) {

    fun getLines(): List<BusLine> {
        val lineStopMappings = repository.getLineStopPointMappings()
        val stopsByLine = lineStopMappings.groupBy { it.lineNumber }
        val lines = stopsByLine.map { toBusLine(it) }
        val sortedLines = lines.sortedByDescending { it.numberOfStops }
        return sortedLines.take(10)
    }

    private fun toBusLine(it: Map.Entry<Int, List<LineStopPointMapping>>) =
        BusLine(
            numberOfStops = it.value.size,
            lineNumber = it.key
        )
}