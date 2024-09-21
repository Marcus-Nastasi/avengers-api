package com.dio.arch.heroes.resource.avenger

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AvengerEntityRepo : JpaRepository<AvengerEntity, UUID> {}
