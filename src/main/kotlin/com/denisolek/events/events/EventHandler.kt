package com.denisolek.events.events

interface EventHandler<in T : Event> {
    fun canHandle(e: Event): Boolean
    fun handle(e: T)
}
