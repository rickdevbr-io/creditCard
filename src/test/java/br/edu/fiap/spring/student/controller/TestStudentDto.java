package br.edu.fiap.spring.student.controller;

import br.edu.fiap.spring.helper.HelperStudentDtoBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TestStudentDto {
    @Test
    public void mustToString() {
        StudentDto studentDto = HelperStudentDtoBuilder.mockEntityToStudentDto();
        assertEquals("StudentDto(id=1, rm=107740, identification=identification, name=Name, nickname=Nickname, email=email@email.com.br, born=Sun Jun 10 23:00:00 BRT 1990, createdDate=Thu Dec 10 14:00:00 BRT 2020)", studentDto.toString());
    }
}
