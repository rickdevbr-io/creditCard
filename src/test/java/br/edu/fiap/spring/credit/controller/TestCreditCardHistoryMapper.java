package br.edu.fiap.spring.credit.controller;

import br.edu.fiap.spring.credit.model.CreditCardHistory;
import br.edu.fiap.spring.helper.HelperCreditCardHistoryBuilder;
import br.edu.fiap.spring.helper.HelperCreditCardHistoryDtoBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class TestCreditCardHistoryMapper {
    @Test
    public void mustEntityToCreditCardHistoryDto_Success() {
        CreditCardHistoryDto creditCardHistoryDto = HelperCreditCardHistoryDtoBuilder.mockEntityToCreditCardHistoryDto();
        CreditCardHistoryDto creditCardHistoryDtoReturn = CreditCardHistoryMapper.entityToCreditCardHistoryDto(HelperCreditCardHistoryBuilder.mockDtoToCreditCardHistory());

        assertEquals(creditCardHistoryDto.getId(), creditCardHistoryDtoReturn.getId());
        assertEquals(creditCardHistoryDto.getCardNumber(), creditCardHistoryDtoReturn.getCardNumber());
        assertEquals(creditCardHistoryDto.getAmountPaid(), creditCardHistoryDtoReturn.getAmountPaid());
        assertNotNull(creditCardHistoryDtoReturn.getId());
    }

    @Test
    public void mustEntityToCreditCardHistoryDto_ifNull() {
        assertEquals(new CreditCardHistoryDto(), CreditCardHistoryMapper.entityToCreditCardHistoryDto(null));
    }

    @Test
    public void mustDtoToCreditCardHistory_Success(){
        CreditCardHistory creditCardHistory = HelperCreditCardHistoryBuilder.mockDtoToCreditCardHistory();
        CreditCardHistory creditCardHistoryReturn = CreditCardHistoryMapper.dtoToCreditCardHistory(HelperCreditCardHistoryDtoBuilder.mockEntityToCreditCardHistoryDto());

        assertEquals(creditCardHistory.getId(), creditCardHistoryReturn.getId());
        assertEquals(creditCardHistory.getCardNumber(), creditCardHistoryReturn.getCardNumber());
        assertEquals(creditCardHistory.getAmountPaid(), creditCardHistoryReturn.getAmountPaid());
        assertNotNull(creditCardHistoryReturn.getId());
    }

    @Test
    public void mustDtoToCreditCardHistory_ifNull(){
        assertEquals(new CreditCardHistory(), CreditCardHistoryMapper.dtoToCreditCardHistory(null));
    }
}
