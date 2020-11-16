package br.edu.fiap.spring.student.controller;

import java.util.Date;
import java.util.Objects;

import br.edu.fiap.spring.student.model.Student;

public abstract class StudentMapper {

	public static StudentDto entityToStudentDto(Student entity) {
		if(Objects.isNull(entity))
			return new StudentDto();
		
		return StudentDto.builder()
				.id(entity.getId())
				.rm(entity.getRm())
				.identification(entity.getIdentification())
				.name(entity.getName())
				.nickname(entity.getNickname())
				.email(entity.getEmail())
				.born(entity.getBorn())
				.createdDate(entity.getCreatedDate())
				.build();
	}
	
	public static Student dtoToStudent(StudentDto dto) {
		if(Objects.isNull(dto))
			return new Student();
		
		return Student.builder()
				.id(dto.getId())
				.rm(dto.getRm())
				.identification(dto.getIdentification())
				.name(dto.getName())
				.nickname(dto.getNickname())
				.email(dto.getEmail())
				.born(dto.getBorn())
				.createdDate(new Date())
				.build();
	}
}
