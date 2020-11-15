package br.edu.fiap.spring.credit.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.spring.credit.facade.CreditFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credito")
public class CreditController {

	private final CreditFacade creditFacade;
	
	@PostMapping("/recebimento-transacao")
	public CreditCardHistoryDto saveCreditCardTransaction(@RequestBody(required = false) CreditCardHistoryDto creditCardHistoryDto) {
		return creditFacade.saveCreditCardTransaction(creditCardHistoryDto);
	}

	@PostMapping("/gerar-massa-transacoes")
	public String createMassTransactions() {
		return creditFacade.createMassTransactions();
	}
	
	@PostMapping("/carga-clientes-potenciais")
	public String uploadPotentialCardCustomers() throws IOException {
		return creditFacade.uploadPotentialCardCustomers();
	}
}
