package com.denisolek.events.events

import java.io.Serializable
import java.util.*

class EventEnvelope<T : Event>(
    val id: UUID,
    val event: T
) : Serializable