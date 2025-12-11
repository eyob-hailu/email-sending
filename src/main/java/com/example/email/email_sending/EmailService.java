package com.example.email.email_sending;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailService {

    private final WebClient webClient;

    public EmailService(@Value("${resend.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.resend.com")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public String sendEmail(String from, String to, String subject, String html, String replyTo) {
        
       System.out.println("email sent");

        return webClient.post()
                .uri("/emails")
                .bodyValue(Map.of(
                        "from", from,
                        "to", to,
                        "subject", subject,
                        "html", html,
                        "reply_to", replyTo   // <-- set reply_to dynamically
                ))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
