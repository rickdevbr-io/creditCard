package br.edu.fiap.spring.credit.controller;

import java.util.Objects;

import br.edu.fiap.spring.credit.model.CreditCardHistory;

public abstract class CreditCardHistoryMapper {

	public static CreditCardHistoryDto entityToCreditCardHistoryDto(CreditCardHistory entity) {
		if(Objects.isNull(entity))
			return new CreditCardHistoryDto();
		
		return CreditCardHistoryDto.builder()
				.id(entity.getId())
				.cardNumber(entity.getCardNumber())
				.amountPaid(entity.getAmountPaid())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static CreditCardHistory dtoToCreditCardHistory(CreditCardHistoryDto dto) {
		if(Objects.isNull(dto))
			return new CreditCardHistory();
		
		return CreditCardHistory.builder()
				.id(dto.getId())
				.cardNumber(dto.getCardNumber())
				.amountPaid(dto.getAmountPaid())
				.createdDate(dto.getCreatedDate())
				.build();
	}
}
