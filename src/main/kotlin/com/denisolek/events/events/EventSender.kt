package com.denisolek.events.events

interface EventSender<T : Event> {
    fun send(e: EventEnvelope<T>)
}
