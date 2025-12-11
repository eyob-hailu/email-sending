package com.example.email.email_sending;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"resend.api.key=dummy",
		"resend.from=dummy@resend.dev",
		"resend.to=test@example.com"
})
class EmailSendingApplicationTests {

	@Test
	void contextLoads() {
	}

}
