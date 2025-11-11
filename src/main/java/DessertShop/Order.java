/*File: "Order.java"
 * Lab 5a: Dessert Shop, Part 5—Print Receipt
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 2, 2024
 * Description:
 * 		* Created a print format for the order Receipt
 * 		* Added Receipt Headers, Dividers, and End
 * 		* Added each item on the list with its correct format to be printed on the Receipt
 * 		* Accurately place indentations, padding, and structure for the TOTALS Section of the receipt
 */

package DessertShop;

import java.util.ArrayList;

public class Order {

    private ArrayList<DessertItem> order;

    // Default constructor
    public Order() {
        order = new ArrayList<DessertItem>();
    }

    // Getter method for order
    public ArrayList<DessertItem> getOrderList() {
        return order;
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
        finalOutput += "\n------------------------------------------------------------------------------------\n";

        // Return the final receipt
        return finalOutput;
    }

}//END of Order Class

