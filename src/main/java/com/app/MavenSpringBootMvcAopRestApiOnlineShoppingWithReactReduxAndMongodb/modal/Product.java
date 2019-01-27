package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "E-CommerceApp_Product")
@TypeAlias("product")
public class Product {
	
	@Id
    private String id;
	
	@Field(value = "Product_Name")
	private String name;
	
	@Field(value = "Product_Category")
	private String category;
	
	@Field(value = "Product_Brand")
	private String brand;
	
	@Field(value = "Product_Size")
	private String size;
	
	@Field(value = "Product_Discount")
	private Integer discount;
	
	@Field(value = "Product_Price")
	private int price;
	
	@Field(value = "Product_Arrival")
	private String arrival;

	@Field(value = "Product_PictureUrl")
    private String pictureUrl;

	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param category
	 * @param brand
	 * @param size
	 * @param discount
	 * @param price
	 * @param arrival
	 * @param pictureUrl
	 */
	public Product(String id, String name, String category, String brand, String size, Integer discount, int price, String arrival,
			String pictureUrl) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.size = size;
		this.discount = discount;
		this.price = price;
		this.arrival = arrival;
		this.pictureUrl = pictureUrl;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}

	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
