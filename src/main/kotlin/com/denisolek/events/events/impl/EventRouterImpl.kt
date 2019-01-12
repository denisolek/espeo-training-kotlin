package com.denisolek.events.events.impl

import com.denisolek.events.events.Event
import com.denisolek.events.events.EventEnvelope
import com.denisolek.events.events.EventHandler
import com.denisolek.events.events.EventRouter
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class EventRouterImpl
    (
    val handlers: Collection<EventHandler<Event>>
)
    : EventRouter {
    private val log = KotlinLogging.logger {}

    override fun route(e: EventEnvelope<Event>) {
        log.info("Routing event envelope: {}", e.id)
        handlers!!.stream()
            .filter { h -> h.canHandle(e.event) }
            .map { h -> h as EventHandler<Event> }
            .forEach { h -> h.handle(e.event) }
    }
}
