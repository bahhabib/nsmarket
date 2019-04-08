package com.mb.appli.nsmarket.domain.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.mb.appli.nsmarket.domain.Basket;
import com.mb.appli.nsmarket.domain.GroupedPricePromotion;
import com.mb.appli.nsmarket.domain.Product;

public class BasketTest {
	
	@Test
	public void createAEmptybasketTest() {
		Basket basket = new Basket();
		System.out.println(basket.toString());
		Assert.assertTrue(basket.getBasketPrice().equals(BigDecimal.ZERO));
	}
	
	@Test
	public void createBasketWithOneProduct() {
		Basket basket = new Basket();
		Product product = new Product("product1", BigDecimal.valueOf(10));
		basket.addProduct(product);
		basket.addProduct(product);
		
		System.out.println(basket.toString());
		Assert.assertTrue(basket.getBasketPrice().equals(20));
	}
	
	@Test
	public void createBasketWithDiffProduct() {
		Basket basket = new Basket();
		Product product = new Product("product1", BigDecimal.valueOf(10));
		Product product1 = new Product("product2", BigDecimal.valueOf(5));
		basket.addProduct(product);
		basket.addProduct(product);
		
		basket.addProduct(product1);
		basket.addProduct(product1);
		
		System.out.println(basket.toString());
		Assert.assertTrue(basket.getBasketPrice().equals(BigDecimal.valueOf(30)));
	}
	
	@Test
	public void createBasketWithDiffProductAndPromotionOnProduct1() {
		Basket basket = new Basket();
		Product product = new Product("product1", BigDecimal.valueOf(10));
		product.setPromotion(new GroupedPricePromotion("Get two for one price", 2, BigDecimal.valueOf(10)));
		Product product2 = new Product("product2", BigDecimal.valueOf(5));
		basket.addProduct(product,2L);	
		basket.addProduct(product2,2L);
		
		System.out.println(basket.toString());
		Assert.assertTrue(basket.getBasketPrice().equals(BigDecimal.valueOf(20)));
	}

}
