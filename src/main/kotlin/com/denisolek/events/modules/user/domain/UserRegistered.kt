package com.denisolek.events.modules.user.domain

import java.util.*

data class UserRegistered(
    val id: UUID ? = null,
    val name: String,
    val role: Role
) : UserEvent