package com.denisolek.events.modules.user.rabbit

import com.denisolek.events.events.Event
import com.denisolek.events.events.EventEnvelope
import com.denisolek.events.events.EventLogger
import com.denisolek.events.modules.user.rabbit.UserRabbitConfig.Companion.USER_QUEUE
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
@RabbitListener(queues = [USER_QUEUE])
class UserReceiver {
    private val logger: EventLogger? = null
    private val log = KotlinLogging.logger {}

    @RabbitHandler(isDefault = true)
    fun receive(e: EventEnvelope<Event>) {
        log.info("Received event envelope: {}", e.id)
        logger!!.logEvent(e)
    }
}
