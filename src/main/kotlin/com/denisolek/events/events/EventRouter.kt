package com.denisolek.events.events

interface EventRouter {
    fun route(e: EventEnvelope<Event>)
}
