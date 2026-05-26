package com.cttc.FirstSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSuccessMessage(String toEmail, String userName, Integer otp) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(toEmail);
		msg.setSubject("Registration Success");
		msg.setText("Hello, " + userName + ", Your OTP is : " + otp);
		mailSender.send(msg);
	}

}
