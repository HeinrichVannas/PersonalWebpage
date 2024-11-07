package com.example.backend.emailservice;

public class EmailRequest {
    private String name;
    private String email;
    private String message;

    private String recaptchaToken;

    public EmailRequest(String name, String email, String message, String recaptchaToken) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.recaptchaToken = recaptchaToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getRecaptchaToken() {
        return recaptchaToken;
    }

    public void setRecaptchaToken(String recaptchaToken) {
        this.recaptchaToken = recaptchaToken;
    }
}
