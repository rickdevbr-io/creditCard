package br.edu.fiap.spring.credit.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PotentialCardCustomersRepository extends CrudRepository<PotentialCardCustomers, Long>, JpaSpecificationExecutor<PotentialCardCustomers>{

    List<PotentialCardCustomers> findAll();

    Optional<PotentialCardCustomers> findByRm(Long rm);

}
