package fr.alexander.apicsharp.error

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException
import org.springframework.boot.context.properties.bind.validation.BindValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur est survenue", ex.message)
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(BindValidationException::class)
    fun handleValidationException(ex: BindValidationException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.BAD_REQUEST, "Erreur de validation", ex.message)
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConfigDataResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ConfigDataResourceNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.NOT_FOUND, "Ressource non trouvée", ex.message)
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }
}