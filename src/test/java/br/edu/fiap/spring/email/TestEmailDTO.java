package br.edu.fiap.spring.email;

import br.edu.fiap.spring.helper.HelperEmailDtoBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TestEmailDTO {
    @Test
    public void mustToString() {
        EmailDTO emailDTO = HelperEmailDtoBuilder.mockEntityToEmailDTO();
        assertEquals("EmailDTO(id=1, to=email@gmail.com, subject=subject, message=message)", emailDTO.toString());
    }
}
