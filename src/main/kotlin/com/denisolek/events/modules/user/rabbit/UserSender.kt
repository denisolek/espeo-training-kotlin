package com.denisolek.events.modules.user.rabbit

import com.denisolek.events.events.EventEnvelope
import com.denisolek.events.events.EventSender
import com.denisolek.events.modules.user.domain.UserEvent
import com.denisolek.events.modules.user.rabbit.UserRabbitConfig.Companion.USER_REGISTERED_EXCHANGE
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class UserSender(
    private val rabbitTemplate: RabbitTemplate
) : EventSender<UserEvent> {
    private val log = KotlinLogging.logger {}

   override fun send(e: EventEnvelope<UserEvent>) {
        log.info("Sending event envelope: {}", e.id)
        rabbitTemplate.convertAndSend(USER_REGISTERED_EXCHANGE, "", e)
    }
}
