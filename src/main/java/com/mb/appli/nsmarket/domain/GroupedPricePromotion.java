package com.mb.appli.nsmarket.domain;

import java.math.BigDecimal;

public class GroupedPricePromotion extends PromotionWithLabel {
	
	private Integer validGroupedQty = new Integer(0);
	private BigDecimal groupedQtyPrice = BigDecimal.ZERO;
	
	
	/***
	 * * 
	 * 
	 * @param validGroupedQty group of quantity to apply promotion
	 * @param  groupedPrice price to apply to validGroupedQty
	 */
	public GroupedPricePromotion(String label, Integer validGroupedQty, BigDecimal groupedQtyPrice) {
		super(label);
		this.validGroupedQty = validGroupedQty;
		this.groupedQtyPrice = groupedQtyPrice;
		
	}
	
	public GroupedPricePromotion(String label, String validGroupedQty, String groupedQtyPrice) {
		this(label, Integer.parseInt(validGroupedQty), new BigDecimal(groupedQtyPrice));
	}

	@Override
	public BigDecimal apply(BigDecimal priceUnit, Long qty) {
		BigDecimal qtyGroupedBy3 = BigDecimal.valueOf(qty.intValue() / validGroupedQty);
		BigDecimal remainingQty = BigDecimal.valueOf(qty.intValue() % validGroupedQty);
		return qtyGroupedBy3.setScale(0).multiply(groupedQtyPrice).add(remainingQty.multiply(priceUnit));
	}

}
