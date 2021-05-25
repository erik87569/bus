package org.erik.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

internal class BusServiceTest {

    private val mockedRepository: BussRepository = mock(BussRepository::class.java)

    @Test
    fun getLines_moreLinesThanTen_tenWithMostStopsReturned() {
        val mockedLines = createMockedLines(11);
        `when`(mockedRepository.getLineStopPointMappings()).thenReturn(mockedLines)
        val buslines = BusService(mockedRepository).getLines()

        assertEquals(10, buslines.size)

        assertEquals(11, buslines.first().numberOfStops)
        assertEquals(11, buslines.first().lineNumber)
        assertEquals(2, buslines.last().numberOfStops)
        assertEquals(2, buslines.last().lineNumber)
    }

    @Test
    fun getLines_lessThanTen_allReturned() {
        val mockedLines = createMockedLines(3);
        `when`(mockedRepository.getLineStopPointMappings()).thenReturn(mockedLines)
        val buslines = BusService(mockedRepository).getLines()

        assertEquals(3, buslines.size)

        assertEquals(3, buslines.first().numberOfStops)
        assertEquals(3, buslines.first().lineNumber)
        assertEquals(1, buslines.last().numberOfStops)
        assertEquals(1, buslines.last().lineNumber)
    }

    private fun createMockedLines(numberOfLines: Int): List<LineStopPointMapping>? {
        var lineStopPointMappings = mutableListOf<LineStopPointMapping>()

        for (i in 1..numberOfLines) {
            for (j in 1..i) {
                var lineStopPointMapping = LineStopPointMapping(
                    lineNumber = i,
                    stopPointNumber = j
                )

                lineStopPointMappings.add(lineStopPointMapping)
            }
        }
        return lineStopPointMappings
    }
}