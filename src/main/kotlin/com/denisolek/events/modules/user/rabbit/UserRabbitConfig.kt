package com.denisolek.events.modules.user.rabbit

import com.denisolek.events.rabbit.QueueCreator.createQueue
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserRabbitConfig {

    @Bean
    fun userQueue(): Queue {
        return createQueue(USER_QUEUE)
    }

    @Bean
    fun userRegistrated(): FanoutExchange {
        return FanoutExchange(USER_REGISTERED_EXCHANGE)
    }

    @Bean
    fun userRegisteredBinding(userQueue: Queue, userRegistered: FanoutExchange): Binding {
        return BindingBuilder.bind(userQueue).to(userRegistered)
    }

    companion object {
        internal const val USER_QUEUE = "user-queue"
        internal const val USER_REGISTERED_EXCHANGE = "user-registered-exchange"
    }
}
