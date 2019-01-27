package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao.IAdminUserDAO;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.AdminUser;

@Service
public class AdminUserService implements IAdminUserDAO {
		
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveAdminUser(AdminUser admin) throws Exception {
		// TODO Auto-generated method stub
		mongoTemplate.save(admin);
	}

	@Override
	public AdminUser adminUserLogin(AdminUser admin) throws Exception {
		// TODO Auto-generated method stub
		Query executeAdminLoginQuery = new Query();
		executeAdminLoginQuery.fields().include("id");
		executeAdminLoginQuery.fields().include("username");
		executeAdminLoginQuery.fields().include("password");
		executeAdminLoginQuery.addCriteria(Criteria.where("username").is(admin.getUsername()).and("password").is(admin.getPassword()));
		AdminUser finializeAdminLoginQuery = mongoTemplate.findOne(executeAdminLoginQuery, AdminUser.class);
		return finializeAdminLoginQuery;
	}	
}
