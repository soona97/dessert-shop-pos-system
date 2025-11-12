/*File: "Customer.java"
 * Lab 7b: Dessert Shop, Part 10—Customer Class
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin 
 * Date: Feb 24, 2024
 * Description:
 * 		* Create the customer class with the following instructions:
 * 				Attributes:
 * 					String custName
 * 					ArrayList<Order> orderHistory
 *					int custID
 *					int nextCustID = 1000 --> This Will be the Static filed because we want it to remain the same.
 *
 *		* Line 40: A constructor that takes a single String argument for custName. Be sure to initialize OR set all other fields appropriately.
 *
 *		*The following methods:
 *				public String getName()
 *				public int getID()
 *				public ArrayList<Order> getOrderHistory()
 *				public void setName(String aCustName)
 *				public void addToHistory(Order order)
 */


package DessertShop;

import java.util.ArrayList;

public class Customer {
	
	//Static field to keep track of the next customer ID
	private static int nextCustID = 1000;
	
	//Attributes
	private String custName;
	private ArrayList<Order> orderHistory;
	private int custID;
	
	//Default Constructor
	public Customer() {
		custName = "";
		custID = 0;
	}
	
	//Constructor with One Argument
	public Customer(String aCustName) {
		custName = aCustName;
		orderHistory = new ArrayList<Order>();
		custID = nextCustID++;
	}
	
	// Getter methods
    public String getName() {
        return custName;
    }

    public int getID() {
        return custID;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    // Setter method
    public void setName(String aCustName) {
        custName = aCustName;
    }

    // Method to add an order to the customer's order history
    public void addToHistory(Order order) {
        orderHistory.add(order);
    }

}
