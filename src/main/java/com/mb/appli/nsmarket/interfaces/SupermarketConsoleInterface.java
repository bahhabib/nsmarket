package com.mb.appli.nsmarket.interfaces;

import java.io.Console;

import com.mb.appli.nsmarket.domain.SuperMarket;

public class SupermarketConsoleInterface {

	public void startConsoleInterface() {

		SuperMarket smarket = new SuperMarket();
		smarket.startUp();

		StringBuilder buffer = new StringBuilder();
		buffer.append("###########################################################");
		buffer.append("#              WELCOME TO SUPERMARKET                 #####");
		buffer.append("# commands:                                           #####");
		buffer.append("#													 #####");
		buffer.append("# ADD productname qty : add product to basket  		 #####");
		buffer.append("# 'productname' name of product to add in basket      #####");
		buffer.append("# 'qty' quantity to add 		                         #####");
		buffer.append("#													 #####");
		buffer.append("# PLIST : list of products in SUPERMARKET 			 #####");
		buffer.append("#													 #####");
		buffer.append("# BASKET : show BASKET 			 					 #####");
		buffer.append("#													 #####");
		buffer.append("###########################################################");
	}

	public void startCommandLine() {
		while (true) {
			Console console = System.console();
			String uservalue = console.readLine(">");
			dispatchToCommand(uservalue);
		}

	}

	public void dispatchToCommand(String commandLine) {
		String[] cmdValue = commandLine.split(" ");
		String cmdType = cmdValue[0];
		switch (cmdType.trim()) {
		case "ADD":
			addToBasket(cmdValue);
			break;

		case "PLIST":
			addToProducts(cmdValue);
			break;

		case "BASKET":
			showToBasket(cmdValue);
			break;

		default:
			break;
		}

	}

	private void showToBasket(String[] cmdValue) {
		// TODO Auto-generated method stub
		
	}

	private void addToProducts(String[] cmdValue) {
		// TODO Auto-generated method stub
		
	}

	private void addToBasket(String[] cmdValue) {
		// TODO Auto-generated method stub
		
	}

}
