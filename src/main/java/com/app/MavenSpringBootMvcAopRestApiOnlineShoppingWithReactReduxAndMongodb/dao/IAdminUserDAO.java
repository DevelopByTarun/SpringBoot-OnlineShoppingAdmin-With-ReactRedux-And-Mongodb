package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao;

import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.AdminUser;

public interface IAdminUserDAO {
	
	public void saveAdminUser(AdminUser admin) throws Exception;
	
	public AdminUser adminUserLogin(AdminUser admin) throws Exception;
}
