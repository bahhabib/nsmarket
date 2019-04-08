package com.mb.appli.nsmarket.domain.test;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.mb.appli.nsmarket.domain.GroupedPricePromotion;
import com.mb.appli.nsmarket.domain.Product;

public class ProductTest {

	@Test
	public void calculatePriceForOneQuantityOfProduct() {
		Product product = new Product("product 1", new BigDecimal(10));
		product.getPriceOf(1L).compareTo(new BigDecimal(10));
		Assert.assertTrue(product.getPriceOf(1L).equals(new BigDecimal(10)));

	}

	@Test
	public void calculatePriceForTwoQuantityOfProduct() {
		Product product = new Product("product 1", new BigDecimal(10));
		product.getPriceOf(2L).compareTo(new BigDecimal(20));
		Assert.assertTrue(product.getPriceOf(1L).equals(new BigDecimal(10)));

	}
	
	
	@Test
	public void calculatePriceOf2WithPromotion2For1() {
		Product product = new Product("product 1", new BigDecimal(10));
		product.setPromotion(new GroupedPricePromotion("Buy One Get one free",2, product.getPriceUnit()));
		Assert.assertTrue(product.getPriceOf(2L).compareTo(new BigDecimal(10)) == 0);

	}
	
	@Test
	public void calculatePriceOf4WithPromotion2For1() {
		Product product = new Product("product 1", new BigDecimal(10));
		product.setPromotion(new GroupedPricePromotion("Buy One Get one free", 2, product.getPriceUnit()));
		Assert.assertTrue(product.getPriceOf(3L).compareTo(new BigDecimal(20)) == 0);

	}

	@Test
	public void calculatePriceOf3WithPromotion3For2() {
		Product product = new Product("product 1", new BigDecimal(10));
		BigDecimal groupedPricePromotion = product.getPriceUnit().multiply(BigDecimal.valueOf(2));
		product.setPromotion(new GroupedPricePromotion("3for2",3, groupedPricePromotion));
		Assert.assertTrue(product.getPriceOf(3L).compareTo(new BigDecimal(20)) == 0);

	}

	@Test
	public void calculatePriceOf4WithPromotion3For2() {
		Product product = new Product("product 1", new BigDecimal(10));
		BigDecimal groupedPricePromotion = product.getPriceUnit().multiply(BigDecimal.valueOf(2));
		product.setPromotion(new GroupedPricePromotion("3for2",3, groupedPricePromotion));
		Assert.assertTrue(product.getPriceOf(4L).compareTo(new BigDecimal(30)) == 0);

	}
	

}
