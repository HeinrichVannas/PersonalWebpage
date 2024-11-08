package com.example.backend.emailservice;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

@Service
public class EmailService {
    private static Logger log = LogManager.getLogger(EmailService.class);
    @Value("${sendgrid.api.key}")
    private String sendgridApiKey;

    public String sendEmail(String fromEmail, String subject, String body) throws IOException {
        Email from = new Email("heinivannas@gmail.com");
        Email toEmail = new Email("heinrichvannas@gmail.com");
        com.sendgrid.helpers.mail.objects.Content content = new com.sendgrid.helpers.mail.objects.Content("text/plain", fromEmail + "\n" + body);
        Mail mail = new Mail(from, subject, toEmail, content);

        SendGrid sg = new SendGrid(sendgridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            log.info("Body: " + response.getBody() + ", StatusCode: " + response.getStatusCode() + ", Headers: " + response.getHeaders());
            return response.getBody();
        } catch (IOException ex) {
            throw ex;
        }
    }
}