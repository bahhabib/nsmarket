package com.mb.appli.nsmarket.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Basket of client
 * 
 *
 */
public class Basket {

	private String clientRef = "UNKNOWN";

	private Map<Product, Long> items = new HashMap<Product, Long>();

	public Basket() {

	}

	public Basket(String clientRef) {
		this.clientRef = clientRef;
	}

	public void addProduct(Product product, Long qty) {
		items.put(product, plusQuantityOf(product, qty));
	}

	public void addProduct(Product product) {
		addProduct(product, 1L);
	}

	public BigDecimal getBasketPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for (Entry<Product, Long> item : items.entrySet()) {
			total = total.add(item.getKey().getPriceOf(item.getValue()));
		}
		return total;
	}

	private Long plusQuantityOf(Product product, Long qty) {
		Long currentQty = items.get(product) != null ? items.get(product) : 0L;
		return currentQty + qty;

	}
	
	public Boolean isEmpty() {
		return items.isEmpty();
	}

	public String getClientRef() {
		return clientRef;
	}

	public void setClientRef(String clientRef) {
		this.clientRef = clientRef;
	}

	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("## BASKET (client : "+clientRef+") ##").append("\n");

		if (items.isEmpty()) {
			buffer.append("no article in basket").append("\n");
		} else {
			buffer.append("Product in basket : ").append("\n");
		}

		for (Entry<Product, Long> entry : items.entrySet()) {
			buffer.append("- item [" + entry.getKey().toString() + ", quantity: " + entry.getValue() + ", sub-total : "
					+ entry.getKey().getPriceOf(entry.getValue()) + "]\n");

		}
		buffer.append("basket total : ").append(this.getBasketPrice()).append("\n");
		buffer.append("______________________________________________").append("\n");
		return buffer.toString();

	}

}
