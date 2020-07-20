package salesTax;

import java.text.DecimalFormat;

public enum InputList {
	//Product names and corresponding prices, separated into shopping carts
	INPUT1 (new String[] {"book", "music cd", "chocolate bar"}, new double[]{12.49, 14.99, 0.85}, new boolean[] {true, false, true}, new boolean[] {false, false, false}),
	INPUT2 (new String[] {"imported box of chocolates", "imported bottle of perfume"}, new double[]{10.00, 47.50}, new boolean[] {false, false}, new boolean[] {true, true}),
	INPUT3 (new String[] {"imported bottle of perfume", "bottle of perfume", "headache pills", "imported chocolates"}, new double[] {27.99, 18.99, 9.75, 11.25}, new boolean[] {false, false, true, false}, new boolean[] {true, false, false, true});
	
	private final String[] name;
	private final double[] price;
	private final boolean[] isExempt;
	private final boolean[] isImport;
	
	private final double taxRate;
	private final double importTax;
	
	private final DecimalFormat df;
	
	InputList(String[] name, double[] price, boolean[] exempt, boolean[] isImport){
		this.name = name;
		this.price = price;
		this.isExempt = exempt;
		this.isImport = isImport;
		
		taxRate = 0.1; //10%
		importTax = 1.05; //extra 5%
		df = new DecimalFormat("#.00"); //for rounding to 2 decimal places
	}
	
	int getLength() {
		return name.length;
	}
	
	String getName(int i) {
		return name[i];
	}
	
	String getPrice(int i) {
		if(isImport[i]) {
			return df.format(price[i] * importTax);
		}
		return df.format(price[i]);
	}
	
	//for the total
	String getFinalPrice() {
		double total = 0.00;
		
		for(int i = 0; i < name.length; i++) {
			if(isImport[i]) {
				total += (price[i] * importTax) * taxRate;
			}
			total += price[i];
			total += price[i] * taxRate;
		}
		
		return df.format(total);
	}
	
	String getTotalTax() {
		double total = 0;
		
		for(int i = 0; i < name.length; i++) {
			if(!isExempt[i]) {
				if(isImport[i]) {
					total += (price[i] * importTax) * taxRate;
				} else {
					total += price[i] * taxRate;
				}
			}
		}
		
		return df.format(total);
	}
}