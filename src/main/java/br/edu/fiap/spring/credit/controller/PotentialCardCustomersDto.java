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
public class PotentialCardCustomersDto {

	private Long id;
	
	private Long rm;
	
	private String clientName;
	
	private int cardNumber;
	
	private BigDecimal maximumSpend;
	
	private BigDecimal minimumSpend;
	
	private Date createdDate;
	
}
