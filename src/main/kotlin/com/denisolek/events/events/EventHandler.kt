package com.denisolek.events.events

interface EventHandler<T : Event> {
    fun canHandle(e: Event): Boolean
    fun handle(e: T)
}
