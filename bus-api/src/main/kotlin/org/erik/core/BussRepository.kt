package org.erik.core

interface BussRepository {
    fun getLineStopPointMappings(): List<LineStopPointMapping>
}