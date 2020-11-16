package br.edu.fiap.spring.credit.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardHistoryRepository extends CrudRepository<CreditCardHistory, Long>, JpaSpecificationExecutor<CreditCardHistory>{

    List<CreditCardHistory> findAll();

    List<CreditCardHistory> findByCardNumber (int cardNumber);

}
