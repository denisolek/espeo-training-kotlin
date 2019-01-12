package com.denisolek.events.events

interface EventLogger {
    fun logEvent(e: EventEnvelope<Event>)
}
