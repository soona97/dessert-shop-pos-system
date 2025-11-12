/*File: "Cookie.java"
 * Lab 7a: Dessert Shop, Part 9—Combine Like Items
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 * 		* Line 15: Implement the generic SameItem<> interface.
 * 		* Line 62 -70: Include the isSameAs(T) method:
 * 				return true if the calling item and the item passed in as an argument (other) have the same: name & PricePerDozen
 */

package DessertShop;

public class Cookie extends DessertItem implements SameItem<Cookie> {

    //Attributes
    private int cookieQty;
    private double pricePerDozen;

    //Default Constructor
    public Cookie() {
        super();
        setPackaging("");        //Interface method
        cookieQty = 0;
        pricePerDozen = 0.0;
    }

    //Constructor with Three Parameters
    public Cookie(String aName, int aCookieQty, double aPricePerDozen) {
        super(aName);
        setPackaging("Box");        //Interface method
        cookieQty = aCookieQty;
        pricePerDozen = aPricePerDozen;
    }

    //Getter Methods
    public int getCookieQty() {
        return cookieQty;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    //Setter Methods
    public void setCookieQty(int aCookieQty) {
        cookieQty = aCookieQty;
    }

    public void setPricePerDozen(double apricePerDozen) {
        pricePerDozen = apricePerDozen;
    }

    //calculateCost() Override
    public double calculateCost() {

        return cookieQty * (pricePerDozen / 12);
    }

    //isSameAs()
    public boolean isSameAs(Cookie other) {
        // Check if the names are the same
        boolean namesMatch = getName().equals(other.getName());

        // Check if the price per dozen is the same
        boolean pricesMatch = pricePerDozen == other.pricePerDozen;

        // Return true if both the name and price per dozen match, otherwise return false
        return namesMatch && pricesMatch;
    }

    //Format the Cookie item toString Method to accurately place indentations, padding, and structure
    public String toString() {
        // Create formatted strings for each part of the item
        String line1 = String.format("%s Cookie (%s)", getName(), getPackaging()); //Added Packaging Interface
        String line2Pt1 = String.format("%d cookie(s) @ $%.2f/dozen:", cookieQty, pricePerDozen);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        // Combine the formatted strings into a single formatted string with appropriate spacing
        return String.format("%s\n  %-45s%17s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
    }

}// End of child Cookie Class to DessertItem Parent
