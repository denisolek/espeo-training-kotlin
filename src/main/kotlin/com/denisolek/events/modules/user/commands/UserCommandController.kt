package com.denisolek.events.modules.user.commands

import com.denisolek.events.events.EventEnvelope
import com.denisolek.events.modules.user.domain.UserRegistered
import com.denisolek.events.modules.user.rabbit.UserSender
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID.randomUUID

@RestController
class UserCommandController(
    private val sender: UserSender
) {
    private val log = KotlinLogging.logger {}

    @PostMapping("/users")
    fun registerUser(@RequestBody userRegistered: UserRegistered) {
        log.info("Received user registration request")
        sender.send(
            EventEnvelope(
                id = randomUUID(),
                event = userRegistered
            )
        )
    }
}
