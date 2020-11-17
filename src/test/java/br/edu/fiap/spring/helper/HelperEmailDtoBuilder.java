package br.edu.fiap.spring.helper;

import br.edu.fiap.spring.email.EmailDTO;

public class HelperEmailDtoBuilder {
    public static EmailDTO mockEntityToEmailDTO() {
        return EmailDTO.builder()
                .id(1L)
                .to("email@gmail.com")
                .subject("subject")
                .message("message")
                .build();
    }
}
