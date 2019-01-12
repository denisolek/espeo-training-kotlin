package com.denisolek.events.events

interface EventStore {
    fun write(e: EventEnvelope<Event>)
}
