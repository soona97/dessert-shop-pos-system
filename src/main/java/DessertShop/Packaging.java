/*File: "Packaging.java"
 * Lab 5b: Dessert Shop, Part 6—Packaging
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 10, 2024
 * Description: Created Interface for packaging which will be implemented on DessertItem Class and set on each child class.
 */


package DessertShop;

public interface Packaging {

    //getPackaging() that takes no arguments and returns a String
    String getPackaging();

    //setPackaging(String) that takes a single String argument and returns void
    void setPackaging(String packaging);

}//END of Packaging Interface
