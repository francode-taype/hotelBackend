package com.francode.hotelBackend.business.mapper;

import com.francode.hotelBackend.business.mapper.generic.Mapper;
import com.francode.hotelBackend.domain.entity.Payment;
import com.francode.hotelBackend.presentation.dto.request.PaymentRequestDTO;
import com.francode.hotelBackend.presentation.dto.response.PaymentResponseDTO;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PaymentMapper extends Mapper<PaymentRequestDTO, PaymentResponseDTO, Payment> {

    @Override
    Payment toEntity(PaymentRequestDTO dto);

    @Override
    PaymentResponseDTO toResponseDTO(Payment entity);

    @Override
    void updateEntityFromDTO(PaymentRequestDTO dto, @MappingTarget Payment entity);
}
