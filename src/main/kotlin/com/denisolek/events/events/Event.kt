package com.denisolek.events.events

import java.io.Serializable
import java.util.function.Consumer

interface Event : Serializable {
    fun apply(handler: Consumer<Event>) {
        handler.accept(this)
    }
}
