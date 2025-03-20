package com.francode.hotelBackend.presentation.dto.request.Reservation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


@Constraint(validatedBy = CheckOutAfterCheckInValidator.class)
public @interface CheckOutAfterCheckIn {
    String message() default "La fecha de salida debe ser posterior a la fecha de entrada";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}

class CheckOutAfterCheckInValidator implements ConstraintValidator<CheckOutAfterCheckIn, ReservationRequestDTO> {

    @Override
    public boolean isValid(ReservationRequestDTO value, ConstraintValidatorContext context) {
        if (value.getCheckInDate() != null && value.getCheckOutDate() != null) {
            return value.getCheckOutDate().isAfter(value.getCheckInDate()); // La fecha de salida debe ser posterior a la de entrada
        }
        return true;
    }
}