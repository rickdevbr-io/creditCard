package br.edu.fiap.spring.email.service;

import br.edu.fiap.spring.credit.facade.CreditCardHistoryService;
import br.edu.fiap.spring.credit.facade.PotentialCardCustomersService;
import br.edu.fiap.spring.credit.model.CreditCardHistory;
import br.edu.fiap.spring.credit.model.PotentialCardCustomers;
import br.edu.fiap.spring.email.controller.EmailDTO;
import br.edu.fiap.spring.student.model.Student;
import br.edu.fiap.spring.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;


@Service
@ConfigurationProperties
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    private final StudentService studentService;
    private final PotentialCardCustomersService potentialCardCustomersService;
    private final CreditCardHistoryService creditCardHistoryService;
    private static final String SUBJECT = "Credit Card History";
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailDTO emailDTO) throws MessagingException, IOException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        helper.setTo(emailDTO.getTo());
        helper.setText(emailDTO.getMessage(), true);
        helper.setSubject(emailDTO.getSubject());

        javaMailSender.send(message);

    }

    public EmailDTO EmailBuild(long rm) {
        EmailDTO emailDTO = new EmailDTO();

        Student student = GetStudent(rm);
        PotentialCardCustomers potentialCardCustomers;
        List<CreditCardHistory> creditCardHistory;
        String message = "";

        if (student.getId() != null) {
            potentialCardCustomers = GetStudentPotentialCardCustomer(rm);
            if (potentialCardCustomers != null) {
                message += "<body>";
                message += "<h1> CREDIT CARD HISTORY </h1>";
                message += "<b>NAME: </b>" + potentialCardCustomers.getClientName() + "<br>";
                message += "<b>CREDIT CARD NUMBER: </b>" + potentialCardCustomers.getCardNumber() + "<br><br>";
                creditCardHistory = GetPotentialCreditCardHistory(potentialCardCustomers.getCardNumber());
                if (creditCardHistory != null) {
                    Iterator<CreditCardHistory> iterator = creditCardHistory.listIterator();
                    int i = 0;

                    message += "<table style='text-align:left'>";
                    message += "<tr style='text-align:left'><th><b>Card Number</b></th>" + "<th><b>Amount Paid</b></th>" + "<th><b>Data</b></th></tr>";

                    while (i < creditCardHistory.size()) {
                        message += "<tr>";
                        message += BuildHTMLTable(String.valueOf(creditCardHistory.get(i).getCardNumber()));
                        message += BuildHTMLTable(String.valueOf(creditCardHistory.get(i).getAmountPaid()));
                        message += BuildHTMLTable(String.valueOf(creditCardHistory.get(i).getCreatedDate()));
                        message += "</tr>";
                        i++;
                    }

                    message += "</table></body>";
                } else
                    return null;
            } else
                return null;
        } else
            return null;

        emailDTO.setTo(student.getEmail());
        emailDTO.setSubject(SUBJECT);
        emailDTO.setMessage(message);

        return emailDTO;
    }

    public String BuildHTMLTable(String value) {
        return "<td>" + value + "</td>";
    }


    public Student GetStudent(long rm) {
        return studentService.findStudent(rm);
    }

    public PotentialCardCustomers GetStudentPotentialCardCustomer(long rm) {
        return potentialCardCustomersService.findPotentialCardCustomer(rm);
    }

    public List<CreditCardHistory> GetPotentialCreditCardHistory(int cardNumber) {
        return creditCardHistoryService.findCreditCardHistories(cardNumber);
    }
}
