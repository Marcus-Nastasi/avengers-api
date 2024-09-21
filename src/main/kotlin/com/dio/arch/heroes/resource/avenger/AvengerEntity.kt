package com.dio.arch.heroes.resource.avenger

import com.dio.arch.heroes.domain.avenger.Avenger
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.validator.constraints.UUID

@Entity

data class AvengerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,
    @Column(nullable = false)
    val nick: String,
    @Column(nullable = false)
    val person: String,
    @Column
    val description: String?,
    @Column
    val history: String?
) {
    fun toAvenger() = Avenger(id, nick, person, description, history)

    companion object {
        fun from(avenger: Avenger) = AvengerEntity(
            id = avenger.id,
            nick = avenger.nick,
            description = avenger.description,
            history = avenger.history,
            person = avenger.person
        )
    }
}
