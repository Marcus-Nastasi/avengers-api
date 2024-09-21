package com.dio.arch.heroes.application.web.resource.response

import com.dio.arch.heroes.domain.avenger.Avenger
import java.util.UUID

data class AvengerResponse(
    val id: UUID? = null,
    val nick: String,
    val person: String,
    val description: String? = "",
    val history: String? = ""
) {
    companion object {
        fun from(avenger: Avenger) = AvengerResponse(
            id = avenger.id,
            nick = avenger.nick,
            person = avenger.person,
            description = avenger.description,
            history = avenger.history
        )
    }
}
