package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao.IProductDAO;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.Product;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.repository.ProductRepository;

@Service
public class ProductService implements IProductDAO {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
			
	@Override
	public boolean saveProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.save(product) != null;
	}

	@Override
	public void deleteProduct(String id) throws Exception {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, Product.class);
	}

	@Override
	public Product getProduct(String id) throws Exception {
		// TODO Auto-generated method stub
		Product getProduct = mongoTemplate.findById(id, Product.class);
		return getProduct;
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		Query selectCategoryArrivalQuery = new Query();
		selectCategoryArrivalQuery.fields().include("id");
		selectCategoryArrivalQuery.fields().include("name");
		selectCategoryArrivalQuery.fields().include("category");
		selectCategoryArrivalQuery.fields().include("brand");
		selectCategoryArrivalQuery.fields().include("size");
		selectCategoryArrivalQuery.fields().include("discount");
		selectCategoryArrivalQuery.fields().include("price");
		selectCategoryArrivalQuery.fields().include("arrival");
		selectCategoryArrivalQuery.fields().include("pictureUrl");
		selectCategoryArrivalQuery.addCriteria(Criteria.where("category").is(category));		
		List<Product> productListByCategoryArrival = mongoTemplate.find(selectCategoryArrivalQuery, Product.class);
		return productListByCategoryArrival;
	}	
}
