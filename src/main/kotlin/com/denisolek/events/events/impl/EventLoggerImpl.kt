package com.denisolek.events.events.impl

import com.denisolek.events.events.*
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class EventLoggerImpl(
    val router: EventRouter,
    val store: EventStore
) : EventLogger {
    private val log = KotlinLogging.logger {}

    override fun logEvent(e: EventEnvelope<Event>) {
        log.info("Persisting event envelope: {}", e.id)
        store.write(e)
        router.route(e)
    }
}
