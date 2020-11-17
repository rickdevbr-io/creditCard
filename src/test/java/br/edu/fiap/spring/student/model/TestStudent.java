package br.edu.fiap.spring.student.model;

import br.edu.fiap.spring.helper.HelperStudentBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TestStudent {
    @Test
    public void mustToString() {
        Student student = HelperStudentBuilder.mockDtoToStudent();
        assertEquals("Student(id=1, rm=107740, identification=identification, name=Name, nickname=Nickname, email=email@email.com.br, born=Sun Jun 10 23:00:00 BRT 1990, createdDate=Thu Dec 10 14:00:00 BRT 2020)", student.toString());
    }
}
