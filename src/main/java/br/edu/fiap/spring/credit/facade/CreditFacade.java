package br.edu.fiap.spring.credit.facade;

import org.springframework.stereotype.Service;

import br.edu.fiap.spring.credit.controller.CreditCardHistoryDto;
import br.edu.fiap.spring.credit.controller.CreditCardHistoryMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreditFacade {

	private final CreditCardHistoryService creditCardHistoryService;
	private final PotentialCardCustomersService potentialCardCustomersService;
	
	public CreditCardHistoryDto saveCreditCardTransaction (CreditCardHistoryDto creditCardHistoryDto) {
		
		return CreditCardHistoryMapper.entityToCreditCardHistoryDto(
				creditCardHistoryService.save(
						CreditCardHistoryMapper.dtoToCreditCardHistory(creditCardHistoryDto)
						)
				);
	}
	
	public String createMassTransactions() {
		return creditCardHistoryService.createMassTransactions();
	}
	
}
