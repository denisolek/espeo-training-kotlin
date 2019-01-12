package com.denisolek.events.db

import org.springframework.stereotype.Component

import java.util.HashMap
import java.util.UUID

@Component
class DB {
    val storage: MutableMap<UUID, Any> = mutableMapOf()
}
