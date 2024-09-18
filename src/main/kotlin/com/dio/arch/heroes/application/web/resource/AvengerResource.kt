package com.dio.arch.heroes.application.web.resource

import com.dio.arch.heroes.application.web.resource.request.AvengerRequest
import com.dio.arch.heroes.application.web.resource.response.AvengerResponse
import com.dio.arch.heroes.domain.avenger.AvengerRepo
import jakarta.validation.Valid
import org.hibernate.validator.constraints.UUID
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val API_PATH = "/v1/api/avenger";

@RestController
@RequestMapping(value = [API_PATH])
class AvengerResource(
    @Autowired private val repository: AvengerRepo
) {
    @GetMapping
    fun getAvengers(): ResponseEntity<List<AvengerResponse>> {
        return repository.getAvengers()
            .map { AvengerResponse.from(it) }
            .let { ResponseEntity.ok().body(it) };
    }

    @GetMapping("{id}")
    fun getAvengerDetail(@PathVariable("id") id: UUID): ResponseEntity<AvengerResponse> {
        return ResponseEntity.ok(AvengerResponse.from(repository.getDetail(id)));
    }

    @PostMapping("/register")
    fun createAvenger(@Valid @RequestBody request: AvengerRequest): ResponseEntity<AvengerResponse> {
        return request.toAvenger()
            .run { repository.create(this) }
            .let {
                ResponseEntity.created(URI("$API_PATH/${it.id}")).body(AvengerResponse.from(it))
            }
    }

    @PatchMapping("/update/{id}")
    fun updateAvenger(
            @PathVariable("id") id: UUID,
            @Valid @RequestBody request: AvengerRequest
    ): ResponseEntity<AvengerResponse> {
        return repository.getDetail(id).let {
            AvengerRequest.to(it.id, request).apply {
                repository.update(this)
            }.let { a ->
                ResponseEntity.ok().body(AvengerResponse.from(a))
            }
        }
    }
}
