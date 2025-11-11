/*File: "Candy.java"
 * Lab 5b: Dessert Shop, Part 6—Packaging
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 10, 2024
 * Description:
 * 		* Call the setPackaging(String) defined in the superclass from within the subclass constructors.
 * 		* Pass String argument to set packaging = "Bag"
 * 		* Update toString() method to include the packaging type in "()" on the receipt
 */

package DessertShop;

public class Candy extends DessertItem {

    //Attributes
    private double candyWeight;
    private double pricePerPound;

    //Default Constructor
    public Candy() {
        super();
        setPackaging("");        //Interface method
        candyWeight = 0.0;
        pricePerPound = 0.0;
    }

    //Constructor with One Parameter
    public Candy(String aName, double aCandyWeight, double aPricePerPound) {
        super(aName);
        setPackaging("Bag");        //Interface method
        candyWeight = aCandyWeight;
        pricePerPound = aPricePerPound;
    }

    //Getter Methods
    public double getCandyWeight() {
        return candyWeight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    //Setter Methods
    public void setCandyWeight(double aCandyWeight) {
        candyWeight = aCandyWeight;
    }

    public void setPricePerPound(double aPricePerPound) {
        pricePerPound = aPricePerPound;
    }

    //calculateCost() Override
    public double calculateCost() {
        return candyWeight * pricePerPound;
    }

    //Format the Candy item toString Method to accurately place indentations, padding, and structure
    public String toString() {
        // Create formatted strings for each part of the item
        String line1 = String.format("%s (%s)", getName(), getPackaging()); //Added Packaging Interface
        String line2Pt1 = String.format("%.2f lbs. @ $%.2f/lb.:", candyWeight, pricePerPound);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        // Combine the formatted strings into a single formatted string with appropriate spacing
        return String.format("%s\n  %-45s%17s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
    }

}//END of child Class Candy
