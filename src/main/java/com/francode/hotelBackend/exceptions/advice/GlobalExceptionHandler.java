package com.francode.hotelBackend.exceptions.advice;

import com.francode.hotelBackend.exceptions.DTOs.ApiErrorDTO;
import com.francode.hotelBackend.exceptions.DTOs.ApiResponseDTO;
import com.francode.hotelBackend.exceptions.custom.NoRecordsException;
import com.francode.hotelBackend.exceptions.custom.NotFoundException;
import com.francode.hotelBackend.exceptions.custom.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepción 404 - URL no existe
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponseDTO> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ApiResponseDTO response = new ApiResponseDTO(404, "La URL solicitada no existe: " + ex.getRequestURL());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Manejo de excepción 404 - Recurso no encontrado
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponseDTO> hadleNotFoundException(NotFoundException ex) {
        ApiResponseDTO response = new ApiResponseDTO(404, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Manejo de excepción 400 - Error de validación
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponseDTO> handleValidationException(ValidationException ex) {
        ApiResponseDTO response = new ApiResponseDTO(400, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepción 200 - Excepción sin registros
    @ExceptionHandler(NoRecordsException.class)
    public ResponseEntity<ApiResponseDTO> handleNoRecordsException(NoRecordsException ex) {
        ApiResponseDTO response = new ApiResponseDTO(200, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGlobalException(Exception ex, WebRequest request) {
        ApiErrorDTO errorDTO = new ApiErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocurrió un error inesperado",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}