package com.example.backend.emailservice;

import java.util.List;

public class ReCaptchaResponse {
    private boolean success;  // Whether the reCAPTCHA was successful
    private double score;     // The score of the reCAPTCHA (0.0 - 1.0)
    private String action;    // The action name for this request
    private String challenge_ts;  // The timestamp when the challenge was solved
    private String hostname;  // The hostname of the site where the reCAPTCHA was solved
    private List<String> errorCodes; // Optional error codes (if any)

    // Getters and setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getChallengeTs() {
        return challenge_ts;
    }

    public void setChallengeTs(String challenge_ts) {
        this.challenge_ts = challenge_ts;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
