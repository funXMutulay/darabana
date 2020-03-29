package org.quantum.nine.nioun.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
		try {
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.send(message);

	}

}
