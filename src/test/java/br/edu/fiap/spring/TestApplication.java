package br.edu.fiap.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TestApplication {
    @Test
    public void main() {
        Application.main(new String[]{});
    }
}
