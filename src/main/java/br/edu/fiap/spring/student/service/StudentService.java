package br.edu.fiap.spring.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.fiap.spring.student.model.Student;
import br.edu.fiap.spring.student.model.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	public Student findStudent(Long rm){
		Optional<Student> student = studentRepository.findByRm(rm);
		
		if(student.isEmpty())
			return new Student();  
		
		return student.get();
	}
	
	public List<Student> findStudents(){
		List<Student> students = studentRepository.findAll();
		
		if(students.size() < 1) {
			return new ArrayList<Student>();
		}
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}
