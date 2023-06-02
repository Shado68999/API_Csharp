package fr.alexander.apicsharp.error

import org.springframework.http.HttpStatus

data class ErrorResponse(
        val status : HttpStatus,
        val message : String,
        val details : String?
)
