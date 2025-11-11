/*File: "Sundae.java"
 * Lab 5b: Dessert Shop, Part 6—Packaging
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 10, 2024
 * Description:
 * 		* Call the setPackaging(String) defined in the superclass from within the subclass constructors.
 * 		* Pass String argument to set packaging = "Boat"
 * 		* Update toString() method to include the packaging type in "()" on the receipt
 */

package DessertShop;

public class Sundae extends IceCream {

    //Attributes
    private String toppingName;
    private double toppingPrice;

    //Default Constructor
    public Sundae() {
        super();
        setPackaging("");        //Interface method
        toppingName = "";
        toppingPrice = 0.0;
    }

    //Parameter Constructor
    public Sundae(String aName, int aScoopCount, double aPricePerScoop, String aToppingName, double aToppingPrice) {
        super(aName, aScoopCount, aPricePerScoop);
        setPackaging("Boat");        //Interface method
        toppingName = aToppingName;
        toppingPrice = aToppingPrice;
    }

    //Getter Methods
    public String getToppingName() {
        return toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    //Setter Methods
    public void setToppingName(String aToppingName) {
        toppingName = aToppingName;
    }

    public void setToppingPrice(double aToppingPrice) {
        toppingPrice = aToppingPrice;
    }

    //calculateCost() Override
    public double calculateCost() {
        return super.calculateCost() + toppingPrice;
    }

	/*
	//To display the whole name of the Sundae
	public String toString() {
	    String sundaeName = getToppingName() + " " + getName() + " Sundae";
	    return String.format("%-35s$%-9.2f[Tax: $%.2f]", sundaeName, calculateCost(), calculateTax());
	}
	 */

    // Format the Sundae item toString Method to accurately place indentations, padding, and structure
    public String toString() {
        // Create formatted strings for each part of the item
        String line1 = String.format("%s %s Sundae (%s)", toppingName, getName(), getPackaging());        //Added Packaging Interface
        String line2 = String.format("  %d scoops of %s ice cream @ $%.2f/scoop", getScoopCount(), getName(), getPricePerScoop());

        String line3Pt1 = String.format("%s topping @ $%.2f:", toppingName, toppingPrice);
        String line3Pt2 = String.format("$%.2f", calculateCost());
        String line3Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        String line3 = String.format("  %-45s%17s%17s", line3Pt1, line3Pt2, line3Pt3);

        //String output = line1 + "\n" + line2 + "\n" + line3;

        // Combine the formatted strings
        return line1 + "\n" + line2 + "\n" + line3;
    }

}//END of Sundae Class child to IceCream Class
