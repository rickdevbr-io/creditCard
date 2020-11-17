package br.edu.fiap.spring.email.controller;

import br.edu.fiap.spring.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private static final String EMAIL_ENVIADO = "Email enviado com sucesso!";
    private final EmailService emailService;


    @GetMapping("send-mail/{rm}")
    public String SendEmail(@PathVariable long rm) throws Exception {
        ResponseEntity<Object> responseEntity;

        try {

            EmailDTO emailDTO = (EmailDTO) emailService.EmailBuild(rm);
            if (emailDTO != null)
                emailService.sendEmail(emailDTO);
            else
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");


            return EMAIL_ENVIADO;

        } catch (ResponseStatusException e) {
            return e.getMessage();
        } catch (MessagingException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}