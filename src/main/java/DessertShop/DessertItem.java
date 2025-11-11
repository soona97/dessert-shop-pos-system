/*File: "DessertItem.java"
 * Lab 6b: Dessert Shop Part 8: Sort Receipt
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 17, 2024
 * Description:
 * 		* Line 17: Implement Comparable Interface
 * 		* Include a new method that overrides the Comparable compareTo() method and returns the following:
 * 			    Line 75: -1 if the other item costs more
 * 				Line 78: 1 if the calling object costs more
 * 				Line 81: 0 if the cost is the same amount
 */

package DessertShop;

public abstract class DessertItem implements Packaging, Comparable<DessertItem> {

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
    public String getName(){
        return name;
    }

    //Added
    public double getTaxPercent(){
        return taxPercent;
    }

    //Added for Interface attribute
    public String getPackaging(){
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
    public void setPackaging(String aPackaging){
        packaging = aPackaging;
    }

    //Abstract method override in all the other classes it will be called.
    public abstract double calculateCost();

    //Calculate taxes for each Dessert Item
    public double calculateTax() {
        return calculateCost() * (taxPercent/100);
    }

    //Override the compareTo() method to compare dessert items based on cost
    public int compareTo(DessertItem other) {
        if(this.calculateCost() > other.calculateCost()) {
            return 1;
        }
        else if (this.calculateCost() < other.calculateCost()) {
            return -1;
        }
        return 0;
    }//END of compareTo() method


}//END of DessertItem Class
