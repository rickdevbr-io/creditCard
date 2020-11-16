package br.edu.fiap.spring.credit.facade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Service;

import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.credit.model.PotentialCardCustomersRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PotentialCardCustomersService {

	private final PotentialCardCustomersRepository potentialCardCustomersRepository;
	
	public PotentialCardCustomers savePotentialCardCustomers(PotentialCardCustomers potentialCardCustomers) {
		return potentialCardCustomersRepository.save(potentialCardCustomers);
	}
	
	public String uploadPotentialCardCustomers() throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("lista_alunos.txt"))) {
			String line;
			while( (line = reader.readLine()) != null ){
				
				if(!line.contains("--") && !line.isBlank() && !line.isEmpty()) {
					String clientName = line.substring(0, 41).trim();
					int cardNumber = Integer.valueOf(line.substring(41,48).trim());
					BigDecimal maximumSpend = new BigDecimal(Double.valueOf(line.substring(49, 52).trim()));
					BigDecimal minimumSpend = new BigDecimal(Double.valueOf(line.substring(53, 54).trim()));
					
					PotentialCardCustomers data = 
							PotentialCardCustomers.builder()
							.clientName(clientName)
							.cardNumber(cardNumber)
							.maximumSpend(maximumSpend)
							.minimumSpend(minimumSpend)
							.createdDate(new Date())
							.build();
					
					if(!Objects.isNull(data)) {
						this.savePotentialCardCustomers(data);
					}
					
					System.out.println(line);
				}
			}
		}
        
        return "carga finalizada com sucesso.";	
	}

	public List<PotentialCardCustomers> findPotentialCardCustomers(){
		List<PotentialCardCustomers> potentialCardCustomers = potentialCardCustomersRepository.findAll();

		if(potentialCardCustomers.size() < 1) {
			return new ArrayList<PotentialCardCustomers>();
		}
		return potentialCardCustomersRepository.findAll();
	}

	public PotentialCardCustomers findPotentialCardCustomer(Long rm){
		Optional<PotentialCardCustomers> potentialCardCustomers = potentialCardCustomersRepository.findByRm(rm);

		if(potentialCardCustomers.isEmpty())
			return new PotentialCardCustomers();

		return potentialCardCustomers.get();
	}


}
