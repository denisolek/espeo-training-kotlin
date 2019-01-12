package com.denisolek.events

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableRabbit
@SpringBootApplication
class EventsApplication

fun main(args: Array<String>) {
    runApplication<EventsApplication>(*args)
}

