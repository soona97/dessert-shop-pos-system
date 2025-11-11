/*File: "IceCream.java"
 * Lab 5b: Dessert Shop, Part 6—Packaging
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 10, 2024
 * Description:
 * 		* Call the setPackaging(String) defined in the superclass from within the subclass constructors.
 * 		* Pass String argument to set packaging = "Bowl"
 * 		* Update toString() method to include the packaging type in "()" on the receipt
 */

package DessertShop;

public class IceCream extends DessertItem {

    //Attributes
    private int scoopCount;
    private double pricePerScoop;

    //Default Constructor
    public IceCream() {
        super();
        setPackaging("");        //Interface method
        scoopCount = 0;
        pricePerScoop = 0.0;
    }

    //Constructor with Three Parameters
    public IceCream(String aName, int aScoopCount, double aPricePerScoop) {
        super(aName);
        setPackaging("Bowl");        //Interface method
        scoopCount = aScoopCount;
        pricePerScoop = aPricePerScoop;
    }

    //Getter Methods
    public int getScoopCount() {
        return scoopCount;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    //Setter Methods
    public void setScoopCount(int aScoopCount) {
        scoopCount = aScoopCount;
    }

    public void setPricePerScoop(double aPricePerScoop) {
        pricePerScoop = aPricePerScoop;
    }

    //calculateCost() Override
    public double calculateCost() {

        return scoopCount * pricePerScoop;
    }

    //Format the IceCream item toString Method to accurately place indentations, padding, and structure
    public String toString() {
        // Create formatted strings for each part of the item
        String line1 = String.format("%s Ice Cream (%s)", getName(), getPackaging()); //Added Packaging Interface
        String line2Pt1 = String.format("%d scoops @ $%.2f/scoop:", scoopCount, pricePerScoop);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        // Combine the formatted strings into a single formatted string with appropriate spacing
        return String.format("%s\n  %-45s%17s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
    }

}//End of Ice Cream Class child to DessertItem Class}
