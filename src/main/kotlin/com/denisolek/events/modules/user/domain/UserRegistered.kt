package com.denisolek.events.modules.user.domain

import java.util.*

data class UserRegistered(
    val id: UUID,
    val name: String,
    val role: Role
) : UserEvent