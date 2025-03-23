package com.francode.hotelBackend.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CleaningResponseDTO {
    private Long id;
    private Long employeeId;
    private Long roomId;
    private LocalDateTime cleaningDate;
    private String status;
}
