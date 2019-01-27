package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao;

import org.springframework.stereotype.Repository;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.Email;

@Repository
public interface IEmailDAO {
	
	public void sendEmail(Email email) throws Exception;
}
