package com.denisolek.events.rabbit

import org.springframework.amqp.core.Queue

import com.denisolek.events.rabbit.RabbitConfig.DEAD_LETTER_EXCHANGE
import com.denisolek.events.rabbit.RabbitConfig.DEAD_LETTER_QUEUE

object QueueCreator {
    private val PROPERTIES = mapOf(
        "x-dead-letter-exchange" to DEAD_LETTER_EXCHANGE,
        "x-dead-letter-routing-key" to DEAD_LETTER_QUEUE
    )

    fun createQueue(name: String): Queue {
        return Queue(name, true, false, false, PROPERTIES)
    }
}
