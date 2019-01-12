package com.denisolek.events.db

import com.denisolek.events.events.Event
import com.denisolek.events.events.EventEnvelope
import com.denisolek.events.events.EventStore
import org.springframework.stereotype.Component
import java.util.*

@Component
class EventStoreImpl : EventStore {
    private val store = HashMap<UUID, EventEnvelope<Event>>()

    override fun write(e: EventEnvelope<Event>) {
        store[e.id] = e
    }
}
