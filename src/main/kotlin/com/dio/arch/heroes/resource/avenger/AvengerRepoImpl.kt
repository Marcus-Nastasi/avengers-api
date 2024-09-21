package com.dio.arch.heroes.resource.avenger

import com.dio.arch.heroes.domain.avenger.Avenger
import com.dio.arch.heroes.domain.avenger.AvengerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AvengerRepoImpl(
    @Autowired private val repo: AvengerEntityRepo
): AvengerRepo {

    override fun getAvengers(): List<Avenger> {
        return repo.findAll().map { it.toAvenger() }
    }

    override fun getDetail(id: UUID): Avenger? {
        return repo.findByIdOrNull(id)?.toAvenger();
    }

    override fun create(avenger: Avenger): Avenger {
        return repo.save(AvengerEntity.from(avenger)).toAvenger();
    }

    override fun update(avenger: Avenger): Avenger? {
        if (avenger.id == null) return null;
        val avengerFound: Avenger = repo.findById(avenger.id).orElseThrow().toAvenger();
        return repo.save(AvengerEntity.from(avengerFound)).toAvenger();
    }

    override fun delete(id: UUID): Avenger? {
        val avenger: Avenger? = repo.findByIdOrNull(id)?.toAvenger();
        repo.deleteById(id);
        return avenger;
    }
}
