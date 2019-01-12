package com.denisolek.events.modules.user.queries

import com.denisolek.events.modules.user.domain.User
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserQueryController(
    private val service: UserQueryService
) {
    private val log = KotlinLogging.logger {}

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable("id") id: UUID): User {
        log.info("Querying for user: {}", id)
        return service.getUser(id)
    }
}
