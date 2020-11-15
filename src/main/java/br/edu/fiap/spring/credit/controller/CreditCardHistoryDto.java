package br.edu.fiap.spring.credit.controller;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreditCardHistoryDto {

	private Long id;
	
	private int cardNumber;
	
	private BigDecimal amountPaid;
	
	private Date createdDate;
	
}
