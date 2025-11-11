/*File: "Order.java"
 * Lab 6a: Dessert Shop, Part 7—Payment Method
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 15, 2024
 * Description:
 * 		* Implement Payable Interface
 * 		* Line 24: Added Attribute of type PayType
 * 		* Line 29: Set payMethod to PayType.CASH in the default constructor.
 * 		* Line 37 and 42: Include two simple methods for getPayType() and setPayType(PayType).
 * 		* Line 121: Add a line to the bottom of the receipt via the toString() method that shows the payment type.
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

