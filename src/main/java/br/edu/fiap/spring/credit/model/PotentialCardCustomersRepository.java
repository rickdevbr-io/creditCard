package br.edu.fiap.spring.credit.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentialCardCustomersRepository extends CrudRepository<PotentialCardCustomers, Long>, JpaSpecificationExecutor<PotentialCardCustomers>{


}
