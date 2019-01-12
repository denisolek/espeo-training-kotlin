package com.denisolek.events.modules.user.commands

import com.denisolek.events.events.Event
import com.denisolek.events.events.EventHandler
import com.denisolek.events.modules.user.domain.UserEvent
import com.denisolek.events.modules.user.domain.UserRegistered
import org.springframework.stereotype.Component

@Component
class UserEventHandler(
    private val service: UserCommandService
) : EventHandler<UserEvent> {

    override fun canHandle(e: Event): Boolean {
        return e is UserEvent
    }

    override fun handle(e: UserEvent) {
        if (e is UserRegistered) {
            handleUserRegistered(e)
        }
    }

    private fun handleUserRegistered(e: UserRegistered) {
        service.register(e)
    }
}
