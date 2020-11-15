package br.edu.fiap.spring.student.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>, JpaSpecificationExecutor<Student>{

	List<Student> findAll();
	
	Optional<Student> findByRm(Long rm);
}
