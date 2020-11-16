package br.edu.fiap.spring.email.service;

import br.edu.fiap.spring.email.controller.EmailDTO;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendEmail(EmailDTO emailDTO) throws MessagingException, IOException;

    Object EmailBuild(long rm) throws Exception;
}