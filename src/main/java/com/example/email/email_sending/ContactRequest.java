package com.example.email.email_sending;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String message;

  
}

