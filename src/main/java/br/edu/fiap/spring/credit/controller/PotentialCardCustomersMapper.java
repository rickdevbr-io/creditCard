package br.edu.fiap.spring.credit.controller;

import java.util.Objects;

import br.edu.fiap.spring.credit.model.PotentialCardCustomers;

public abstract class PotentialCardCustomersMapper {

	public static PotentialCardCustomersDto entityToPotentialCardCustomersDto(PotentialCardCustomers entity) {
		if(Objects.isNull(entity))
			return new PotentialCardCustomersDto();
		
		return PotentialCardCustomersDto.builder()
				.id(entity.getId())
				.rm(entity.getRm())
				.clientName(entity.getClientName())
				.cardNumber(entity.getCardNumber())
				.maximumSpend(entity.getMaximumSpend())
				.minimumSpend(entity.getMinimumSpend())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static PotentialCardCustomers dtoToPotentialCardCustomers(PotentialCardCustomersDto dto) {
		if(Objects.isNull(dto))
			return new PotentialCardCustomers();
		
		return PotentialCardCustomers.builder()
				.id(dto.getId())
				.rm(dto.getRm())
				.clientName(dto.getClientName())
				.cardNumber(dto.getCardNumber())
				.maximumSpend(dto.getMaximumSpend())
				.minimumSpend(dto.getMinimumSpend())
				.createdDate(dto.getCreatedDate())
				.build();
	}
}
