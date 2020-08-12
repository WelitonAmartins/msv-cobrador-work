package br.com.unilito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailFrom;

	public void sendSimpleMessage(String to, String subject, String text) {

		final SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailFrom);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

	}
}
