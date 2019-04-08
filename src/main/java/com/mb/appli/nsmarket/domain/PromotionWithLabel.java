package com.mb.appli.nsmarket.domain;

public abstract class PromotionWithLabel implements Promotion {

	private String label;

	public PromotionWithLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String toString(){
		return label;
	}
	
	
}
