/*File: "DessertItem.java"
 * Lab 5b: Dessert Shop, Part 6—Packaging
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 10, 2024
 * Description:
 * 		* Implement Packaging Interface
 * 		* Add an additional attribute packaging.
 * 		* Add a getter and setter method for declared methods in Packaging getPackaging(), and setPackaging().
 */

package DessertShop;

public abstract class DessertItem implements Packaging {

    // Attributes
    private String name;
    private double taxPercent = 7.25;

    //Interface Attribute
    private String packaging;

    //Default Constructor
    public DessertItem() {
        name = "";
    }

    //Constructor with One Parameter
    public DessertItem(String aName) {
        name = aName;
    }

    //Getter Method for name
    public String getName() {
        return name;
    }

    //Added
    public double getTaxPercent() {
        return taxPercent;
    }

    //Added for Interface attribute
    public String getPackaging() {
        return packaging;
    }

    //Setter method for name
    public void setName(String aName) {
        name = aName;
    }

    //Added
    public void setTaxPercent(double aTaxPercent) {
        taxPercent = aTaxPercent;
    }

    //Added for Interface attribute
    public void setPackaging(String aPackaging) {
        packaging = aPackaging;
    }

    //Abstract method override in all the other classes it will be called.
    public abstract double calculateCost();

    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);
    }

}//END of DessertItem Class
