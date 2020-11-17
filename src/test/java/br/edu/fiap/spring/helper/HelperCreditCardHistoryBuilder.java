package br.edu.fiap.spring.helper;

import br.edu.fiap.spring.credit.model.CreditCardHistory;

import java.math.BigDecimal;
import java.util.Calendar;

public class HelperCreditCardHistoryBuilder {
    public static CreditCardHistory mockDtoToCreditCardHistory() {
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, 11, 10, 14, 0, 0);

        return CreditCardHistory.builder()
                .id(1L)
                .cardNumber(11111)
                .amountPaid(new BigDecimal(10.0))
                .createdDate(createdDate.getTime())
                .build();
    }
}
