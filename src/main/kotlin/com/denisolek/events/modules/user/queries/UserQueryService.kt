package com.denisolek.events.modules.user.queries

import com.denisolek.events.db.DB
import com.denisolek.events.modules.user.domain.User
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserQueryService(
    private val db: DB
) {
    private val log = KotlinLogging.logger {}

    internal fun getUser(id: UUID): User {
        log.info("Retrieving user: {}", id)
        return db.storage[id] as User
    }
}
