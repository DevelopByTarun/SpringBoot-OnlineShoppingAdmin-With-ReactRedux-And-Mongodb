package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao;

import java.util.List;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.Product;

public interface IProductDAO {
		
	public boolean saveProduct(Product product) throws Exception;
	
	public void deleteProduct(String id) throws Exception;
	
	public Product getProduct(String id) throws Exception;
		
	public List<Product> getAllProductsByCategory(String category) throws Exception;
}
