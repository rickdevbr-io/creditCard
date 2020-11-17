package br.edu.fiap.spring.student.controller;

import br.edu.fiap.spring.helper.HelperStudentBuilder;
import br.edu.fiap.spring.helper.HelperStudentDtoBuilder;
import br.edu.fiap.spring.student.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class TestStudentMapper {

    @Test
    public void mustEntityToStudentDto_Success() {
        StudentDto studentDto = HelperStudentDtoBuilder.mockEntityToStudentDto();
        StudentDto studentDtoReturn = StudentMapper.entityToStudentDto(HelperStudentBuilder.mockDtoToStudent());

        assertEquals(studentDto.getId(), studentDtoReturn.getId());
        assertEquals(studentDto.getRm(), studentDtoReturn.getRm());
        assertEquals(studentDto.getIdentification(), studentDtoReturn.getIdentification());
        assertEquals(studentDto.getName(), studentDtoReturn.getName());
        assertEquals(studentDto.getNickname(), studentDtoReturn.getNickname());
        assertNotNull(studentDtoReturn.getBorn());
        assertNotNull(studentDtoReturn.getCreatedDate());
    }

    @Test
    public void mustEntityToStudentDto_ifNull() {
        assertEquals(new StudentDto(), StudentMapper.entityToStudentDto(null));
    }

    @Test
    public void mustDtoToStudent_Success() {
        Student student = HelperStudentBuilder.mockDtoToStudent();
        Student studentReturn = StudentMapper.dtoToStudent(HelperStudentDtoBuilder.mockEntityToStudentDto());

        assertEquals(student.getId(), studentReturn.getId());
        assertEquals(student.getRm(), studentReturn.getRm());
        assertEquals(student.getIdentification(), studentReturn.getIdentification());
        assertEquals(student.getName(), studentReturn.getName());
        assertEquals(student.getNickname(), studentReturn.getNickname());
        assertNotNull(studentReturn.getBorn());
        assertNotNull(studentReturn.getCreatedDate());
    }

    @Test
    public void musDtoToStudent_ifNull() {
        assertEquals(new Student(), StudentMapper.dtoToStudent(null));
    }
}
