package com.francode.hotelBackend.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReservationResponseDTO {

    private Long id;
    private Long clientId;
    private Long roomId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private String status;
    private String comments;
    private String rateType;
    private BigDecimal priceRate;
    private BigDecimal totalPrice;
    private List<PaymentResponseDTO> payments;
}
