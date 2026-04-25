package com.example.email.email_sending;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> appHealth() {
        System.err.println("heath checked");
        return ResponseEntity.ok("Online");
    }

    @PostMapping("/contact")
    public ResponseEntity<String> contact(@RequestBody ContactRequest request) {

        String htmlContent = """
                <h2>New Contact Message</h2>
                <p><strong>Name:</strong> %s</p>
                <p><strong>Email:</strong> %s</p>
                <p><strong>Message:</strong></p>
                <p>%s</p>
                """.formatted(
                request.getName(),
                request.getEmail(),
                request.getMessage());

        emailService.sendEmail(
                "onboarding@resend.dev", // your verified Resend sender
                "eyobajobi@gmail.com", // your receiving email
                "New Contact Form Submission",
                htmlContent,
                request.getEmail() // <-- user email as reply_to
        );

        return ResponseEntity.ok("Message sent successfully!");
    }
}
