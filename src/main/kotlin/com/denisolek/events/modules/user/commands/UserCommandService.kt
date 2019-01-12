package com.denisolek.events.modules.user.commands

import com.denisolek.events.db.DB
import com.denisolek.events.modules.user.domain.User
import com.denisolek.events.modules.user.domain.UserRegistered
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserCommandService(
    private val db: DB
) {
    private val log = KotlinLogging.logger {}
    internal fun register(e: UserRegistered) {
        val id = UUID.randomUUID()
        log.info("Persisting user: {}", id)
        db.storage[id] = User(id, e.name, e.role)
    }
}
