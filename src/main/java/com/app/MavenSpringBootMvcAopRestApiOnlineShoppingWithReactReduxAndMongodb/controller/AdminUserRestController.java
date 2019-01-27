package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao.IAdminUserDAO;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.AdminUser;

@RestController
@RequestMapping("/api/user")
public class AdminUserRestController {
	
	@Autowired
	private IAdminUserDAO adminUserDAO;
	
	@RequestMapping("/login")
	public ResponseEntity<AdminUser> callingAdminUserLogin(@RequestBody AdminUser admin) throws Exception {
		AdminUser adminUserObject = adminUserDAO.adminUserLogin(admin);
		return new ResponseEntity<AdminUser>(adminUserObject, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<AdminUser> signOut() throws Exception {
		return new ResponseEntity<AdminUser>(HttpStatus.OK);
	}
}
