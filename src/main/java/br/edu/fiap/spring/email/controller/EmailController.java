package br.edu.fiap.spring.email.controller;

import br.edu.fiap.spring.credit.facade.CreditCardHistoryService;
import br.edu.fiap.spring.credit.facade.PotentialCardCustomersService;
import br.edu.fiap.spring.credit.model.CreditCardHistory;
import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.email.service.EmailService;
import br.edu.fiap.spring.student.model.Student;
import br.edu.fiap.spring.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private static final String EMAIL_ENVIADO = "Email enviado com sucesso!";
    private final EmailService emailService;


    @GetMapping("send-mail/{rm}")
    public String SendEmail(@PathVariable  long rm) throws Exception {
        ResponseEntity<Object> responseEntity;

        try {

            EmailDTO emailDTO = (EmailDTO) emailService.EmailBuild(rm);
            if(emailDTO!=null)
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