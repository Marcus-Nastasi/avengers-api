package com.dio.arch.heroes.domain.avenger

import org.hibernate.validator.constraints.UUID

data class Avenger(
    val id: UUID? = null,
    val nick: String,
    val person: String,
    val description: String? = null,
    val history: String? = null
)
