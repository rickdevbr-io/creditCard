package br.edu.fiap.spring.credit.controller;

import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.helper.HelperPotentialCardCustomersBuilder;
import br.edu.fiap.spring.helper.HelperPotentialCardCustomersDtoBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class TestPotentialCardCustomersMapper {
    @Test
    public void mustEntityToPotentialCardCustomersDto_Success() {
        PotentialCardCustomers potentialCardCustomers = HelperPotentialCardCustomersBuilder.mockDtoToPotentialCardCustomers();
        PotentialCardCustomers potentialCardCustomersReturn = PotentialCardCustomersMapper.dtoToPotentialCardCustomers(HelperPotentialCardCustomersDtoBuilder.mockEntityToPotentialCardCustomersDto());

        assertEquals(potentialCardCustomers.getId(), potentialCardCustomersReturn.getId());
        assertEquals(potentialCardCustomers.getRm(), potentialCardCustomersReturn.getRm());
        assertEquals(potentialCardCustomers.getClientName(), potentialCardCustomersReturn.getClientName());
        assertEquals(potentialCardCustomers.getCardNumber(), potentialCardCustomersReturn.getCardNumber());
        assertEquals(potentialCardCustomers.getMaximumSpend(), potentialCardCustomersReturn.getMaximumSpend());
        assertEquals(potentialCardCustomers.getMinimumSpend(), potentialCardCustomersReturn.getMinimumSpend());
        assertNotNull(potentialCardCustomersReturn.getCreatedDate());
    }

    @Test
    public void mustEntityToPotentialCardCustomersDto_ifNull() {
        assertEquals(new PotentialCardCustomersDto(), PotentialCardCustomersMapper.entityToPotentialCardCustomersDto(null));
    }

    @Test
    public void mustDtoToPotentialCardCustomers_Success() {
        PotentialCardCustomersDto potentialCardCustomersDto = HelperPotentialCardCustomersDtoBuilder.mockEntityToPotentialCardCustomersDto();
        PotentialCardCustomersDto potentialCardCustomersDtoReturn = PotentialCardCustomersMapper.entityToPotentialCardCustomersDto(HelperPotentialCardCustomersBuilder.mockDtoToPotentialCardCustomers());

        assertEquals(potentialCardCustomersDto.getId(), potentialCardCustomersDtoReturn.getId());
        assertEquals(potentialCardCustomersDto.getRm(), potentialCardCustomersDtoReturn.getRm());
        assertEquals(potentialCardCustomersDto.getClientName(), potentialCardCustomersDtoReturn.getClientName());
        assertEquals(potentialCardCustomersDto.getCardNumber(), potentialCardCustomersDtoReturn.getCardNumber());
        assertEquals(potentialCardCustomersDto.getMaximumSpend(), potentialCardCustomersDtoReturn.getMaximumSpend());
        assertEquals(potentialCardCustomersDto.getMinimumSpend(), potentialCardCustomersDtoReturn.getMinimumSpend());
        assertNotNull(potentialCardCustomersDtoReturn.getCreatedDate());
    }

    @Test
    public void mustDtoToPotentialCardCustomers_ifNull() {
        assertEquals(new PotentialCardCustomers(), PotentialCardCustomersMapper.dtoToPotentialCardCustomers(null));
    }
}
