package br.edu.fiap.spring.helper;

import br.edu.fiap.spring.credit.model.PotentialCardCustomers;

import java.math.BigDecimal;
import java.util.Calendar;

public class HelperPotentialCardCustomersBuilder {
    public static PotentialCardCustomers mockDtoToPotentialCardCustomers() {
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, 11, 10, 14, 0, 0);

        return PotentialCardCustomers.builder()
                .id(1L)
                .rm(2L)
                .clientName("Client")
                .cardNumber(11111)
                .maximumSpend(new BigDecimal(1000.0))
                .minimumSpend(new BigDecimal(50.0))
                .createdDate(createdDate.getTime())
                .build();
    }
}
