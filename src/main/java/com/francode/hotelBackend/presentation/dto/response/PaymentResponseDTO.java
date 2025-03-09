package com.francode.hotelBackend.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponseDTO {

    private Long id;
    private Long reservationId;
    private Double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;
}
