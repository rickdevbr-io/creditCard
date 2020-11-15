package br.edu.fiap.spring.credit.facade;

import org.springframework.stereotype.Service;

import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.credit.model.PotentialCardCustomersRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PotentialCardCustomersService {

	private PotentialCardCustomersRepository potentialCardCustomersRepository;
	
	public PotentialCardCustomers savePotentialCardCustomers(PotentialCardCustomers potentialCardCustomers) {
		return potentialCardCustomersRepository.save(potentialCardCustomers);
	}
	
	
}
