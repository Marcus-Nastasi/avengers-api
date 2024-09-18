package com.dio.arch.heroes.application.web.response

import org.hibernate.validator.constraints.UUID

data class AvengerResponse(
    val id: UUID,
    val nick: String,
    val person: String,
    val description: String,
    val history: String
)
