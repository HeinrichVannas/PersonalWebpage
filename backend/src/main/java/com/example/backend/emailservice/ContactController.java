package com.example.backend.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final EmailService emailService;
    @Value("${recaptcha.secret.key}")
    private String RECAPTCHA_SECRET_KEY;
    @Autowired
    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendContactEmail(@RequestBody EmailRequest email) {
        System.out.println("is api");
        try {
            boolean isReCaptchaValid = verifyReCaptcha(email.getRecaptchaToken());
            System.out.println(isReCaptchaValid);
            if (!isReCaptchaValid) {
                return new ResponseEntity<>("reCAPTCHA verification failed", HttpStatus.BAD_REQUEST);
            }
            String response = emailService.sendEmail(email.getEmail(), email.getName(), email.getMessage());
            System.out.println(response);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean verifyReCaptcha(String recaptchaToken) {
        String url = "https://www.google.com/recaptcha/api/siteverify";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("secret", RECAPTCHA_SECRET_KEY);
        params.add("response", recaptchaToken);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(params);

        RestTemplate restTemplate = new RestTemplate();
        ReCaptchaResponse response = restTemplate.postForObject(builder.toUriString(), null, ReCaptchaResponse.class);

        return response != null && response.isSuccess();
    }
}