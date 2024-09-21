package com.dio.arch.heroes.domain.avenger

import org.hibernate.validator.constraints.UUID

interface AvengerRepo {
    fun getDetail(id: UUID): Avenger?
    fun getAvengers(): List<Avenger>
    fun create(avenger: Avenger): Avenger
    fun update(avenger: Avenger): Avenger?
    fun delete(id: UUID): Avenger?
}
