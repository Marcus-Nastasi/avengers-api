package com.dio.arch.heroes.domain.avenger

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UUID

data class Avenger(
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val id: UUID,
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
)
