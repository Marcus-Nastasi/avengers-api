package com.dio.arch.heroes.application.web.resource

import com.dio.arch.heroes.application.web.resource.request.AvengerRequest
import com.dio.arch.heroes.application.web.resource.response.AvengerResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/v1/api/avenger"])
class AvengerResource {

    @GetMapping
    fun getAvengers(): ResponseEntity<List<AvengerResponse>> {
        return ResponseEntity.ok().body(emptyList<AvengerResponse>());
    }

    @GetMapping("{id}")
    fun getAvengerDetail(@PathVariable("id") id: String): ResponseEntity<AvengerResponse> {
        return ResponseEntity.ok().build<AvengerResponse>();
    }

    @PostMapping("/register")
    fun createAvenger(@Valid @RequestBody request: AvengerRequest): ResponseEntity<AvengerResponse> {
        return ResponseEntity.status(HttpStatus.CREATED).build<AvengerResponse>();
    }


}
