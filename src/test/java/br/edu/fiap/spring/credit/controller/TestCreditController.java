package br.edu.fiap.spring.credit.controller;

import br.edu.fiap.spring.credit.facade.CreditCardHistoryService;
import br.edu.fiap.spring.credit.facade.CreditFacade;
import br.edu.fiap.spring.credit.facade.PotentialCardCustomersService;
import br.edu.fiap.spring.credit.model.CreditCardHistory;
import br.edu.fiap.spring.credit.model.CreditCardHistoryRepository;
import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.credit.model.PotentialCardCustomersRepository;
import br.edu.fiap.spring.helper.HelperCreditCardHistoryBuilder;
import br.edu.fiap.spring.helper.HelperCreditCardHistoryDtoBuilder;
import br.edu.fiap.spring.helper.HelperPotentialCardCustomersBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TestCreditController {

    @Mock
    private CreditCardHistoryRepository mockCreditCardHistoryRepository = Mockito.mock(CreditCardHistoryRepository.class);

    @Mock
    private PotentialCardCustomersRepository mockPotentialCardCustomersRepository = Mockito.mock(PotentialCardCustomersRepository.class);

    private CreditCardHistoryService creditCardHistoryService = new CreditCardHistoryService(mockCreditCardHistoryRepository);

    private PotentialCardCustomersService potentialCardCustomersService = new PotentialCardCustomersService(mockPotentialCardCustomersRepository);

    private CreditFacade creditFacade = new CreditFacade(creditCardHistoryService, potentialCardCustomersService);

    private CreditController creditController = new CreditController(creditFacade);

    @Test
    public void mustSaveCreditCardTransaction_Success() {
        CreditCardHistory creditCardHistory = HelperCreditCardHistoryBuilder.mockDtoToCreditCardHistory();
        CreditCardHistoryDto creditCardHistoryDto = HelperCreditCardHistoryDtoBuilder.mockEntityToCreditCardHistoryDto();

        when(mockCreditCardHistoryRepository.save(any(CreditCardHistory.class))).thenReturn(creditCardHistory);

        this.creditController.saveCreditCardTransaction(creditCardHistoryDto);

        verify(mockCreditCardHistoryRepository, atMostOnce()).save(any(CreditCardHistory.class));
    }

    @Test
    public void mustCreateMassTransactions_Success() {
        CreditCardHistory creditCardHistory = HelperCreditCardHistoryBuilder.mockDtoToCreditCardHistory();

        when(mockCreditCardHistoryRepository.save(any(CreditCardHistory.class))).thenReturn(creditCardHistory);

        this.creditController.createMassTransactions();

        verify(mockCreditCardHistoryRepository, atMostOnce()).save(any(CreditCardHistory.class));
    }

    @Test
    public void mustUploadPotentialCardCustomers_Success() throws IOException {
        PotentialCardCustomers potentialCardCustomers = HelperPotentialCardCustomersBuilder.mockDtoToPotentialCardCustomers();

        when(mockPotentialCardCustomersRepository.save(any(PotentialCardCustomers.class))).thenReturn(potentialCardCustomers);

        this.creditController.uploadPotentialCardCustomers();

        verify(mockPotentialCardCustomersRepository, atMostOnce()).save(any(PotentialCardCustomers.class));
    }
}
