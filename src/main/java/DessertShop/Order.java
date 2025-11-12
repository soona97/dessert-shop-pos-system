/*File: "Order.java"
 * Lab 7a: Dessert Shop, Part 9—Combine Like Items
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 * 		* Line 55-77: If item to be added is of type Candy:
 *				Loop through all other items in the order ArrayList.
 *						If the current other item in the ArrayList being evaluated is also of type Candy and a call to Candy's isSameAs(Candy) method returns true,
 *								add the candyWeight of the item to be added to the already existing item in the order, and
 *								DO NOT add the new item.
 *		* Lines 81-103: If item to be added is of type Cookie:
 * 				Loop through all other items in the order ArrayList.
 *						If the current other item in the ArrayList being evaluated is also of type Cookie and a call to Cookie's isSameAs(Cookie) method returns true,
 *								add the cookieQty of the item to be added to the already existing item in the order, and
 *								DO NOT add the new item. *
 */

package DessertShop;

import java.util.ArrayList;

public class Order implements Payable {


    //Attributes
    private ArrayList<DessertItem> order;
    private PayType payMethod;        //Added PayType attribute created on Payable interface.

    // Default constructor
    public Order() {
        order = new ArrayList<DessertItem>();
        payMethod = PayType.CASH;
    }

    // Getter methods
    public ArrayList<DessertItem> getOrderList() {
        return order;
    }

    public PayType getPayType() {
        return payMethod;
    }

    //Setter Methods
    public void setPayType(PayType aPayMethod) {
        payMethod = aPayMethod;
    }

    // Method to add a DessertItem to the order
    public void addDessertItem(DessertItem item) {

        //Check if the item is an instance of Candy
        if (item instanceof Candy) {

            // Iterate through the existing items in the order
            for (int i = 0; i < order.size(); i++) {

                // Get the current item in the order
                DessertItem otherItem = order.get(i);

                // Check if the current item is also a Candy
                if (otherItem instanceof Candy) {

                    // Check if the candies are the same using the isSameAs method
                    if (((Candy) otherItem).isSameAs(((Candy) item))) {

                        // If the candies are the same, combine their weights
                        ((Candy) otherItem).setCandyWeight(((Candy) item).getCandyWeight() + ((Candy) otherItem).getCandyWeight());

                        // Return from the method as the candies have been combined
                        return;
                    }//END of If statement that started on Line 62
                }//END of If Statement otherItem instance of Candy
            }//END of For Loop to iterate thru Existing items in the order
        }//END of If Statement item instance of Candy


        //Check if the item is an instance of Cookie
        if (item instanceof Cookie) {

            // Iterate through the existing items in the order
            for (int i = 0; i < order.size(); i++) {

                // Get the current item in the order
                DessertItem otherItem = order.get(i);

                // Check if the current item is also a Candy
                if (otherItem instanceof Cookie) {

                    // Check if the candies are the same using the isSameAs method
                    if (((Cookie) otherItem).isSameAs(((Cookie) item))) {

                        // If the candies are the same, combine their weights
                        ((Cookie) otherItem).setCookieQty(((Cookie) item).getCookieQty() + ((Cookie) otherItem).getCookieQty());

                        // Return from the method as the candies have been combined
                        return;
                    }//END of If statement that started on Line 62
                }//END of If Statement otherItem instance of Candy
            }//END of For Loop to iterate thru Existing items in the order
        }//END of If Statement item instance of Candy

        // If the item is not a Candy or doesn't match existing items, add it to the order
        order.add(item);
    }

    // Method to get the number of items in the order
    public int getItemCount() {
        return order.size();
    }

    //OrderCost() for all items
    public double orderCost() {
        double totalCost = 0.0;
        for (DessertItem item : order) {
            totalCost += item.calculateCost();
        }

        return totalCost;
    }

    //Calculate taxes for all items
    public double orderTax() {
        double totalTax = 0.0;
        for (DessertItem item : order) {
            totalTax += item.calculateTax();
        }

        return totalTax;
    }

    //Create the print format for the order
    public String toString() {
        // Create an empty string to store the receipt
        String finalOutput = "";

        // Add the receipt header
        finalOutput += "--------------------------------------Receipt---------------------------------------\n\n";

        // Add each item's toString() output to the receipt
        for (int i = 0; i < order.size(); i++) {
            DessertItem item = order.get(i);
            finalOutput += item.toString() + "\n\n";
        }

        // Add a receipt divider
        finalOutput += "------------------------------------------------------------------------------------\n\n";

        // Calculate and add the order totals to the receipt
        double subtotal = orderCost();
        double totalTax = orderTax();
        double totalCost = subtotal + totalTax;


        String line1 = String.format("Total number of items in order: %d\n", getItemCount());

        //Format for Subtotal Line
        String line2Pt1 = String.format("Order Subtotals:");
        String line2Pt2 = String.format("$%.2f", subtotal);
        String line2Pt3 = String.format("[Tax: $%.2f]", totalTax);

        //Format for Total Line
        String line3Pt1 = String.format("Order Total:");
        String line3Pt2 = String.format("$%.2f", totalCost);

        String line2 = String.format("%-48s%16s%17s", line2Pt1, line2Pt2, line2Pt3);

        String line3 = String.format("%-48s%16s", line3Pt1, line3Pt2);

        //Add to final output the structured format for the Subtotal and Total Lines
        finalOutput += line1 + "\n" + line2 + "\n\n" + line3 + "\n";

        // Add a receipt end
        finalOutput += "\n------------------------------------------------------------------------------------\n\n";

        //ADD line to show the Payment type
        finalOutput += "Paid for with " + payMethod.name();

        // Return the final receipt
        return finalOutput;
    }

}//END of Order Class

