package com.mb.appli.nsmarket.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

	private String name;

	private BigDecimal priceUnit;

	private Promotion promotion;

	public Product(String name, BigDecimal priceUnit) {
		this.name = name;
		this.priceUnit = priceUnit;
	}
	

	public Product(String name, BigDecimal priceUnit,Promotion promotion) {
		this.name = name;
		this.priceUnit = priceUnit;
		this.promotion = promotion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public BigDecimal getPriceOf(Long qty) {
		if (promotion != null) {
			return promotion.apply(this.priceUnit, qty);
		} else {
			return this.priceUnit.multiply(BigDecimal.valueOf(qty));
		}

	}

	public BigDecimal getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(BigDecimal priceUnit) {
		this.priceUnit = priceUnit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "name : " + name + ", unit-price : " + priceUnit + ", promotion : " + (promotion!=null?"'"+promotion.toString()+"'":"'no promotion'");
	}
	
	
	
	

}
