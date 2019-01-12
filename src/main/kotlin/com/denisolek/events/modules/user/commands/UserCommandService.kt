package com.denisolek.events.modules.user.commands

import com.denisolek.events.db.DB
import com.denisolek.events.modules.user.domain.User
import com.denisolek.events.modules.user.domain.UserRegistered
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class UserCommandService(
    private val db: DB
) {
    private val log = KotlinLogging.logger {}
    internal fun register(e: UserRegistered) {
        log.info("Persisting user: {}", e.id)
        db.storage[e.id] = User(e.id, e.name, e.role)
    }
}
