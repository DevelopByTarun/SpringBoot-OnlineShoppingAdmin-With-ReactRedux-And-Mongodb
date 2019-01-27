package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal;

import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component("myEmail")
public class Email {
		
	@NotBlank
	private String yourEmail;
	
	@NotBlank
	private String receiverEmail;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String message;

	/**
	 * @return the yourEmail
	 */
	public String getYourEmail() {
		return yourEmail;
	}

	/**
	 * @param yourEmail the yourEmail to set
	 */
	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}

	/**
	 * @return the receiverEmail
	 */
	public String getReceiverEmail() {
		return receiverEmail;
	}

	/**
	 * @param receiverEmail the receiverEmail to set
	 */
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
