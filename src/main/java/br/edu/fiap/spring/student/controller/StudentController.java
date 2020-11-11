package br.edu.fiap.spring.student.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fiap.spring.student.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aluno")
public class StudentController {

	private final StudentService studentService;
	
	@GetMapping("/lista")
	public List<StudentDto> findStudents(){
		return studentService.findStudents()
		.stream()
		.map(StudentMapper :: entityToStudentDto)
		.collect(Collectors.toList());
	}
	
	@GetMapping("/{rm}")
	public StudentDto findStudent(@PathVariable Long rm) {
		return StudentMapper.entityToStudentDto(
				studentService.findStudent(rm)
				);
	}
	
	@PostMapping("/salvar")
	public StudentDto saveStudent(@RequestBody(required = false) StudentDto studentDto) {
		
		return StudentMapper.entityToStudentDto(
			studentService.save(
					StudentMapper.dtoToStudent(studentDto)
					)
		);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
	}
}
