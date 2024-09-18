package com.dio.arch.heroes.application.web.request

data class AvengerRequest(
    val nick: String,
    val person: String,
    val description: String,
    val history: String
)
