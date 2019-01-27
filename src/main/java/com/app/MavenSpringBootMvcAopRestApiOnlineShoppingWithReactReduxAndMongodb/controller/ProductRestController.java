package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.dao.IProductDAO;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal.Product;
import com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.repository.ProductRepository;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
	
	@Autowired
    private IProductDAO productDAO;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Void> callSaveProduct(@RequestBody Product product, UriComponentsBuilder builder) throws Exception {
		boolean flag = productDAO.saveProduct(product);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/addproduct?id={id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
		
	@PostMapping("/updtproduct/{id}")
	public ResponseEntity<Product> callUpdateProduct(@PathVariable("id") String id, @RequestBody Product product) throws Exception {
		Optional<Product> productData = productRepository.findById(id);
		if(productData.isPresent()) {
			Product getProduct = productData.get();
			getProduct.setName(product.getName());
			getProduct.setCategory(product.getCategory());
			getProduct.setBrand(product.getBrand());
			getProduct.setSize(product.getSize());
			getProduct.setDiscount(product.getDiscount());
			getProduct.setPrice(product.getPrice());
			getProduct.setArrival(product.getArrival());
			getProduct.setPictureUrl(product.getPictureUrl());
			productRepository.save(getProduct);
			return new ResponseEntity<Product>(getProduct, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<Void> callDeleteProduct(@PathVariable("id") String id) throws Exception {
		productDAO.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	@GetMapping("/editproduct/{id}")
	public ResponseEntity<Product> callGetProduct(@PathVariable("id") String id) throws Exception {
		Product proud = productDAO.getProduct(id);
		return new ResponseEntity<Product>(proud, HttpStatus.OK);
	}
		
	@GetMapping("/menJeans")
	public ResponseEntity<List<Product>> fetchAllMenJeans(String category) throws Exception {
		List<Product> menJeansList = productDAO.getAllProductsByCategory("MenJeans");
		return new ResponseEntity<List<Product>>(menJeansList, HttpStatus.OK);
	}
		
	@GetMapping("/menTshirts")
	public ResponseEntity<List<Product>> fetchAllMenTshirts(String category) throws Exception {
		List<Product> menTshirtsList = productDAO.getAllProductsByCategory("MenTshirts");
		return new ResponseEntity<List<Product>>(menTshirtsList, HttpStatus.OK);
	}
	
	@GetMapping("/menShirts")
	public ResponseEntity<List<Product>> fetchAllMenShirts(String category) throws Exception {
		List<Product> menShirtsList = productDAO.getAllProductsByCategory("MenShirts");
		return new ResponseEntity<List<Product>>(menShirtsList, HttpStatus.OK);
	}
	
	@GetMapping("/menShoes")
	public ResponseEntity<List<Product>> fetchAllMenShoes(String category) throws Exception {
		List<Product> menShoesList = productDAO.getAllProductsByCategory("MenShoes");
		return new ResponseEntity<List<Product>>(menShoesList, HttpStatus.OK);
	}
	
	@GetMapping("/menWatches")
	public ResponseEntity<List<Product>> fetchAllMenWatches(String category) throws Exception {
		List<Product> menWatchesList = productDAO.getAllProductsByCategory("MenWatches");
		return new ResponseEntity<List<Product>>(menWatchesList, HttpStatus.OK);
	}
	
	@GetMapping("/menBelts")
	public ResponseEntity<List<Product>> fetchAllMenBelts(String category) throws Exception {
		List<Product> menBeltsList = productDAO.getAllProductsByCategory("MenBelts");
		return new ResponseEntity<List<Product>>(menBeltsList, HttpStatus.OK);
	}
	
	@GetMapping("/womenSalwarSuits")
	public ResponseEntity<List<Product>> fetchAllWomenSalwarSuits(String category) throws Exception {
		List<Product> womenSalwarSuitsList = productDAO.getAllProductsByCategory("WomenSalwarSuits");
		return new ResponseEntity<List<Product>>(womenSalwarSuitsList, HttpStatus.OK);
	}
	
	@GetMapping("/womenHandbags")
	public ResponseEntity<List<Product>> fetchAllWomenHandbags(String category) throws Exception {
		List<Product> womenHandbagsList = productDAO.getAllProductsByCategory("WomenHandbags");
		return new ResponseEntity<List<Product>>(womenHandbagsList, HttpStatus.OK);
	}
	
	@GetMapping("/womenSandals")
	public ResponseEntity<List<Product>> fetchAllWomenSandals(String category) throws Exception {
		List<Product> womenSandalsList = productDAO.getAllProductsByCategory("WomenSandals");
		return new ResponseEntity<List<Product>>(womenSandalsList, HttpStatus.OK);
	}
	
	@GetMapping("/womenWatches")
	public ResponseEntity<List<Product>> fetchAllWomenWatches(String category) throws Exception {
		List<Product> womenWatchesList = productDAO.getAllProductsByCategory("WomenWatches");
		return new ResponseEntity<List<Product>>(womenWatchesList, HttpStatus.OK);
	}
	
	@GetMapping("/womenJewellery")
	public ResponseEntity<List<Product>> fetchAllWomenJewellery(String category) throws Exception {
		List<Product> womenJewelleryList = productDAO.getAllProductsByCategory("WomenJewellery");
		return new ResponseEntity<List<Product>>(womenJewelleryList, HttpStatus.OK);
	}
	
	@GetMapping("/womenSarees")
	public ResponseEntity<List<Product>> fetchAllWomenSarees(String category) throws Exception {
		List<Product> womenSareesList = productDAO.getAllProductsByCategory("WomenSarees");
		return new ResponseEntity<List<Product>>(womenSareesList, HttpStatus.OK);
	}
}
