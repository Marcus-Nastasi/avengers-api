package com.dio.arch.heroes.resource.avenger

import org.hibernate.validator.constraints.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvengerEntityRepo : JpaRepository<AvengerEntity, UUID> {}
