package com.mb.appli.nsmarket.domain;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SuperMarket {
	
	Map<String,Product> products = new HashMap<String,Product>();
	
	public void startUp() {
		products.put("Apple",new Product("Apple",new BigDecimal("0.2"),new GroupedPricePromotion("Buy one Get one free", "2", "0.2")));
		products.put("Orange",new Product("Orange",new BigDecimal("0.5")));
		products.put("Watermelon",new Product("Watermelon",new BigDecimal("0.8"),new GroupedPricePromotion("Three for two", "3", "1.6")));
	}

	public Basket getABasketForAClient(String clientRef) {
			return new Basket(clientRef);
	}

	public Collection<Product> getProducts() {
		return products.values();
	}
	public Product getProduct(String productname) {
		return products.get(productname);
	}
	
	
	
	
}
