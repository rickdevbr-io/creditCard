package br.edu.fiap.spring.helper;

import br.edu.fiap.spring.student.controller.StudentDto;

import java.util.Calendar;

public class HelperStudentDtoBuilder {
    public static StudentDto mockEntityToStudentDto() {
        Calendar born = Calendar.getInstance();
        born.set(1990, 05, 10, 23, 0, 0);
        Calendar createdDate = Calendar.getInstance();
        createdDate.set(2020, 11, 10, 14, 0, 0);

        return StudentDto.builder()
                .id(1L)
                .rm(107740L)
                .identification("identification")
                .name("Name")
                .nickname("Nickname")
                .email("email@email.com.br")
                .born(born.getTime())
                .createdDate(createdDate.getTime())
                .build();
    }
}
