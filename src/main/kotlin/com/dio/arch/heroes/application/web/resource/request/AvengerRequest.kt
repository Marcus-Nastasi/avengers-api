package com.dio.arch.heroes.application.web.resource.request

import com.dio.arch.heroes.domain.avenger.Avenger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.util.UUID

data class AvengerRequest(
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val nick: String,
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val person: String,
    val description: String? = "",
    val history: String? = ""
) {
    fun toAvenger() = Avenger(null, nick, person, description, history)

    companion object {
        fun to(id: UUID?, request: AvengerRequest) = Avenger(
            id = id,
            nick = request.nick,
            person = request.person,
            description = request.description,
            history = request.history
        )
    }
}
