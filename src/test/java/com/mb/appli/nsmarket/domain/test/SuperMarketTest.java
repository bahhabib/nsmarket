package com.mb.appli.nsmarket.domain.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mb.appli.nsmarket.domain.Basket;
import com.mb.appli.nsmarket.domain.Product;
import com.mb.appli.nsmarket.domain.SuperMarket;

public class SuperMarketTest {

	private SuperMarket smarket = new SuperMarket();

	@Before
	public void init() {
		smarket.startUp();
	}

	@Test
	public void superMarketProductsTest() {
		Collection<Product> products = smarket.getProducts();

		for (Product product : products) {
			System.out.println(product.toString());

		}

		Assert.assertFalse(products.isEmpty());
	
	
	}
	
	@Test
	public void getABasketForAClientAndAddNoPromotionProduct() {
		Basket basket = smarket.getABasketForAClient("123");
		basket.addProduct(smarket.getProduct("Orange"),2L);
		System.out.println(basket.toString());
		Assert.assertFalse(basket.isEmpty());
		
	}
	
	@Test
	public void getABasketForAClientAndAddPromotionProduct() {
		Basket basket = smarket.getABasketForAClient("123");
		basket.addProduct(smarket.getProduct("Apple"),2L);
		System.out.println(basket.toString());
		Assert.assertFalse(basket.isEmpty());
		
	}
}
