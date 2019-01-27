package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao.IEmailDAO;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.Email;

@Service
public class EmailService implements IEmailDAO {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(Email email) throws Exception {
		// TODO Auto-generated method stub
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(email.getYourEmail());
		mailMessage.setTo(email.getReceiverEmail());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getMessage());
		mailSender.send(mailMessage);
	}
}
