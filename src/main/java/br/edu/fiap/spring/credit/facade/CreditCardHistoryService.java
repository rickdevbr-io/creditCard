package br.edu.fiap.spring.credit.facade;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.edu.fiap.spring.credit.model.CreditCardHistory;
import br.edu.fiap.spring.credit.model.CreditCardHistoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreditCardHistoryService {

	private final CreditCardHistoryRepository creditCardHistoryRepository;
	
	public CreditCardHistory save(CreditCardHistory creditCardHistory) {
		return creditCardHistoryRepository.save(creditCardHistory);
	}
	
	public String createMassTransactions() {
		Random amountPaidRandom = new Random();
		for(int count = 1; count < 31; count++) {
			CreditCardHistory creditCardHistory = CreditCardHistory.builder()
					.cardNumber(337443)
					.amountPaid(new BigDecimal(amountPaidRandom.nextDouble() * 1000 ))
					.createdDate(Date.valueOf(LocalDate.now().plusDays(count)))
					.build();
			
			this.save(creditCardHistory);
		}
		
		return "massa de transação criada com sucesso";
	}

	public List<CreditCardHistory> findCreditCardHistories(){
		List<CreditCardHistory> creditCardHistory = creditCardHistoryRepository.findAll();

		if(creditCardHistory.size() < 1) {
			return new ArrayList<CreditCardHistory>();
		}
		return creditCardHistoryRepository.findAll();
	}

	public List<CreditCardHistory> findCreditCardHistories(int creditCardNumber){
		List<CreditCardHistory> creditCardHistory = creditCardHistoryRepository.findByCardNumber(creditCardNumber);

		if(creditCardHistory.size() < 1) {
			return new ArrayList<CreditCardHistory>();
		}
		return creditCardHistory;
	}
	
}
