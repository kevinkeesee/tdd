package salesTax;

public class SalesTaxValidation {
	
	public static void main(String[] args) {
		printValues();
	}
	
	// I would like to mention here that asking me to print a static set of predetermined global values is counterintuitive to test driven design.
	// There's no variation, and input for any of my functions would be forced and illogical.
	public static void printValues() {
		
		System.out.println("Output 1:");
		
		for (int i = 0; i < InputList.INPUT1.getLength(); i++) {
			System.out.println("1 " + InputList.INPUT1.getName(i) + ": " + InputList.INPUT1.getPrice(i));
		}
		
		System.out.println("Sales Tax: " + InputList.INPUT1.getTotalTax());
		System.out.println("Total: " + InputList.INPUT1.getFinalPrice());
		System.out.println("**********************************************");
		
		System.out.println("Output 2:");
		
		for (int i = 0; i < InputList.INPUT2.getLength(); i++) {
			System.out.println("1 " + InputList.INPUT2.getName(i) + ": " + InputList.INPUT2.getPrice(i));
		}
		
		// The readme file claims the sales tax is larger than 10% even though it made clear that the extra 5% cost is added flat to the price before tax
		System.out.println("Sales Tax: " + InputList.INPUT2.getTotalTax());
		System.out.println("Total: " + InputList.INPUT2.getFinalPrice());
		System.out.println("**********************************************");
		
		System.out.println("Output 3:");
		
		for (int i = 0; i < InputList.INPUT3.getLength(); i++) {
			System.out.println("1 " + InputList.INPUT3.getName(i) + ": " + InputList.INPUT3.getPrice(i));
		}
		
		System.out.println("Sales Tax: " + InputList.INPUT3.getTotalTax());
		System.out.println("Total: " + InputList.INPUT3.getFinalPrice());
		System.out.println("**********************************************");
	}
}