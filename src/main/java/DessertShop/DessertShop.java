/*File: "DessertShop.java"
 * Lab 8b: Dessert Shop, Part 12—Admin Module
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Mar 2, 2024
 * Description:
 * 		* Line 57: Update your menu choices to include a fifth choice: Admin Module.
 * 		* Line 390-428: The Admin Module choice will call a new method you create, which will present a new set of menu options:
1: 							1: Shop Customer List
2: 							2: Customer Order History
3: 							3: Best Customer
4: 							4: Exit Admin Module
 * 		* Line 431-446: Selecting 1 will show a listing of all Dessert Shop customers and their Customer IDs in a nice format as shown in the Example Run.
 * 		* Line 450-488: Selecting 2 will ask the user for a customer name and then print out all orders (receipts) for that customer
 * 		* Line 492-536: Selecting 3 will display a banner exclaiming who the best customer is based on the number of orders each customer has made
 * 		* Line 492-536: Selecting 4 will return to the previous menu.
 *
 */

package DessertShop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import DessertShop.Payable.PayType;

public class DessertShop {

    //Add a HashMap as a static field to your DessertShop class
    private static HashMap<String, Customer> customerDB = new HashMap<>();

    public static void main(String[] args) {

        //Code Added from Lab4B CREATES MENU TO ADD DESSERT ITEMS TO THE ORDER
        Scanner sIn = new Scanner(System.in);
        String choice;
        DessertItem orderItem;

        //Set the Store OPEN
        boolean closed = false;

        while (!closed) {
            // Create a new instance of the Order class
            Order order = new Order();

            boolean done = false;

            while (!done) {
                System.out.println("\n1: Candy");
                System.out.println("2: Cookie");
                System.out.println("3: Ice Cream");
                System.out.println("4: Sundae");
                System.out.println("5: Admin Module");

                System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
                choice = sIn.nextLine();

                if (choice.equals("")) {
                    done = true;
                } else {
                    switch (choice) {
                        case "1":
                            orderItem = userPromptCandy(sIn);
                            order.addDessertItem(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "2":
                            orderItem = userPromptCookie(sIn);
                            order.addDessertItem(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "3":
                            orderItem = userPromptIceCream(sIn);
                            order.addDessertItem(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "4":
                            orderItem = userPromptSundae(sIn);
                            order.addDessertItem(orderItem);
                            System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
                            break;
                        case "5":
                            adminModule(sIn);
                            break;
                        default:
                            System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
                            break;
                    }//end of switch (choice)

                }//end of if (choice.equals(""))

            }//end of while (!done)


            System.out.println("\n");//END of Code Added Lab4B


            // Add items to the order
            order.addDessertItem(new Candy("Candy Corn", 1.5, 0.25));
            order.addDessertItem(new Candy("Gummy Bears", 0.25, 0.35));
            order.addDessertItem(new Cookie("Chocolate Chip", 6, 3.99));
            order.addDessertItem(new IceCream("Pistachio", 2, 0.79));
            order.addDessertItem(new Sundae("Vanilla", 3, 0.69, "Hot Fudge", 1.29));
            order.addDessertItem(new Cookie("Oatmeal Raisin", 2, 3.45));

            //Ask for the Customer's name
            System.out.print("Enter the customer name: ");
            String customerName = sIn.nextLine();

            //Check if customer exists in database
            Customer customer = customerDB.get(customerName);

            if (customer == null) {
                // Create a new customer if not found
                customer = new Customer(customerName);
                customerDB.put(customerName, customer);
            }

            // Add the order to the customer's order history
            customer.addToHistory(order);

            //Ask user for payment method
            String paymentMethod;
            boolean valid = false;
            while (!valid) {
                System.out.print("What form of payment will be used? (CASH, CARD, PHONE): ");
                paymentMethod = sIn.nextLine();

                for (PayType p : PayType.values()) {
                    if (paymentMethod.equalsIgnoreCase(p.name())) {
                        valid = true;
                        order.setPayType(p);
                        break;
                    }//END of if Statement
                }//END of For Loop
                if (!valid) {
                    System.out.println("That's not a valid form of payment.");
                }
            }//END of While Loop

            //Sort the items in the order
            Collections.sort(order.getOrderList());

            // Replace the code responsible for printing to the console with a single line to print out the receipt
            System.out.println(order); // This will print the receipt

            // After printing the order details print the Customer Name, ID and Total Orders
            System.out.println("\n------------------------------------------------------------------------------------\n");
            System.out.printf("Customer Name: %s  Customer ID: %d  Total Orders: %d\n",
                    customer.getName(), customer.getID(), customer.getOrderHistory().size());

            // Pause and ask user to hit enter to start a new order
            System.out.println("\nPress Enter to start a new order...");
            sIn.nextLine(); // Wait for user to press enter

        }//END of outer While loop for store open or closed

        //Close the Scanner
        sIn.close();

    }//END of main() Method


    //Method for switch case 1 "Candy"
    private static DessertItem userPromptCandy(Scanner sIn) {

        //Declare variables
        String candyType = "";
        double candyWeight = 0.0;
        double pricePerPound = 0.0;

        //Enter Cookie Desired
        System.out.print("\nEnter the type of candy: ");
        candyType = sIn.nextLine();

        //Input validation for cookieQty
        do {
            System.out.println("Enter the Candy weight: ");
            if (sIn.hasNextDouble()) {
                candyWeight = sIn.nextDouble();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! Candy weight must be a whole number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop

        //Input validation for price per Pound
        do {
            System.out.println("Enter price per pound: ");
            if (sIn.hasNextDouble()) {
                pricePerPound = sIn.nextDouble();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! Price per pound must be a number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop

        return new Candy(candyType, candyWeight, pricePerPound);

    }


    //Method for switch case 2 "Cookie"
    private static DessertItem userPromptCookie(Scanner sIn) {

        //Declare variables
        String cookieType = "";
        int cookieQty = 0;
        double pricePerDozen = 0.0;

        //Enter Cookie Desired
        System.out.print("\n\nEnter the type of cookie: ");
        cookieType = sIn.nextLine();

        //Input validation for cookieQty
        do {
            System.out.print("Enter the quantity purchased: ");
            if (sIn.hasNextInt()) {
                cookieQty = sIn.nextInt();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! Cookie quantity must be a whole number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop

        //Input validation for price per Dozen
        do {
            System.out.print("Enter price per dozen: ");
            if (sIn.hasNextDouble()) {
                pricePerDozen = sIn.nextDouble();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! Price per dozen must be a number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop


        return new Cookie(cookieType, cookieQty, pricePerDozen);

    }//END of userPromptCookie()


    //Method for switch case 3 "IceCream"
    private static DessertItem userPromptIceCream(Scanner sIn) {

        //Declare variables
        String iceCreamName = "";
        int scoopCount = 0;
        double pricePerScoop = 0.0;

        //Enter Cookie Desired
        System.out.print("\nEnter the type of Ice Cream used: ");
        iceCreamName = sIn.nextLine();

        //Input validation for number of Scoops
        do {
            System.out.print("Enter the number of scoops: ");
            if (sIn.hasNextInt()) {
                scoopCount = sIn.nextInt();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! number of scoops must be a whole number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop

        //Input validation for price per Dozen
        do {
            System.out.print("Enter price per scoop: ");
            if (sIn.hasNextDouble()) {
                pricePerScoop = sIn.nextDouble();
                sIn.nextLine();
                break;
            } else {
                System.out.println("\nInvalid Entry! Price per scoop must be a number.\n");
                sIn.nextLine();
            }//End of if and else statement

        } while (true);//END of do While Loop


        return new IceCream(iceCreamName, scoopCount, pricePerScoop);

    }

    //Method for switch case 4 "Sundae"
    private static DessertItem userPromptSundae(Scanner sIn) {

        // Declare variables
        String iceCreamName;
        int scoopCount;
        double pricePerScoop;
        String toppingName;
        double toppingPrice;

        // Enter the type of Ice Cream used
        System.out.print("\nEnter the type of Ice Cream: ");
        iceCreamName = sIn.nextLine();

        // Input validation for the number of Scoops
        do {
            System.out.print("Enter the number of scoops: ");
            if (sIn.hasNextInt()) {
                scoopCount = sIn.nextInt();
                sIn.nextLine(); // Consume the newline character
                break;
            } else {
                System.out.println("\nInvalid Entry! Number of scoops must be a whole number.\n");
                sIn.nextLine(); // Consume the invalid input
            }

        } while (true);//END of do While Loop

        // Input validation for price per scoop
        do {
            System.out.print("Enter price per scoop: ");
            if (sIn.hasNextDouble()) {
                pricePerScoop = sIn.nextDouble();
                sIn.nextLine(); // Consume the newline character
                break;
            } else {
                System.out.println("\nInvalid Entry! Price per scoop must be a number.\n");
                sIn.nextLine(); // Consume the invalid input
            }

        } while (true);//END of do While Loop

        // Enter the kind of topping used
        System.out.print("Enter the kind of topping used: ");
        toppingName = sIn.nextLine();

        // Input validation for topping price
        do {
            System.out.print("Enter price for the topping: ");
            if (sIn.hasNextDouble()) {
                toppingPrice = sIn.nextDouble();
                sIn.nextLine(); // Consume the newline character
                break;
            } else {
                System.out.println("\nInvalid Entry! Topping price must be a number.\n");
                sIn.nextLine(); // Consume the invalid input
            }

        } while (true);//END of do While Loop


        return new Sundae(iceCreamName, scoopCount, pricePerScoop, toppingName, toppingPrice);

    }//END of userPromptSundae()


    //Method for switch case 5 "Admin Module"
    private static void adminModule(Scanner sIn) {

        String choice;

        //Use a boolean to control the loop
        boolean exit = false;

        do {
            System.out.println("\n\nAdmin Module\n");
            System.out.println("1: Shop Customer List");
            System.out.println("2: Customer Order History");
            System.out.println("3: Best Customer");
            System.out.println("4: Exit Admin Module");

            System.out.print("What would you like to do? (1–4): ");
            choice = sIn.nextLine();

            switch (choice) {

                case "1":
                    displayCustomerList();
                    break;
                case "2":
                    displayOrderHistory(sIn);
                    break;
                case "3":
                    displayBestCustomer();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
                    break;
            }//END of Switch choice

        } while (!exit);

    }//END of adminModule() method

    //Method for Admin Module Switch case 1
    private static void displayCustomerList() {

        System.out.println("");

        // Iterate over each entry in the customerDB map
        for (Map.Entry<String, Customer> entry : customerDB.entrySet()) {

            // Retrieve the customer's name (key) and customer object (value) from the map entry
            String customerName = entry.getKey();
            Customer customer = entry.getValue();

            // Print the customer's name and ID in a formatted manner
            System.out.println("Customer Name: " + customerName + "\tCustomer ID: " + customer.getID());
        }//END of For Loop

    }//END of displayCustomerList() method


    //Method for Admin Module Switch case 2
    private static void displayOrderHistory(Scanner sIn) {

        // Prompt the user to enter the name of the customer
        System.out.print("Enter the name of the customer: ");

        // Read the customer's name from the user input
        String customerName = sIn.nextLine();

        // Check if the customer exists in the customer database (map)
        if (customerDB.containsKey(customerName)) {

            // Retrieve the Customer object associated with the name
            Customer customer = customerDB.get(customerName);

            // Display the customer's name and ID
            System.out.println("Customer Name: " + customerName + "\tCustomer ID: " + customer.getID());

            // Display a header for the order history
            //System.out.println("Order History:");
            System.out.println("\n---------------------------------------------------------------");

            //Initialize an order number
            int orderNumber = 1;

            // Iterate over each Order object in the customer's order history
            for (Order order : customer.getOrderHistory()) {
                // Print the order number
                System.out.println("\n\nOrder #: " + orderNumber++);
                // Print the details of the order using the order's toString() method
                System.out.println(order);
            }//END of For loop
        } else {
            // If the customer is not found in the database, display a message
            System.out.println("Customer not found.");
        }

    }//END of displayOrderHistory() method


    //Method for Admin Module Switch case 3
    private static void displayBestCustomer() {

        // Initialize variables to track the best customer and the maximum total amount spent
        Customer bestCustomer = null;
        double maxTotalSpent = 0.0;

        // Iterate over all customers in the customer database
        for (Customer customer : customerDB.values()) {

            // Get the total amount spent by the current customer
            double totalSpent = calculateTotalSpent(customer);

            // Check if the current customer has spent more than the current best customer
            if (totalSpent > maxTotalSpent) {
                // If so, update the maximum total amount spent and set the best customer to the current customer
                maxTotalSpent = totalSpent;
                bestCustomer = customer;
            }//END of If statement

        }//END of For Loop

        // Check if a best customer was found
        if (bestCustomer != null) {
            // If a best customer was found, display their name as the most valued customer
            System.out.println("\n---------------------------------------------------------------\n");
            System.out.println("The Dessert Shop's most valued customer is: " + bestCustomer.getName() + "!");
            System.out.println("\n---------------------------------------------------------------\n");
        } else {
            // If no orders were found in the database, display a message indicating no orders were found
            System.out.println("No orders found.");
        }
    }

    // Helper method of Switch case 3
    private static double calculateTotalSpent(Customer customer) {

        double totalSpent = 0.0;

        // Iterate over each order in the customer's order history
        for (Order order : customer.getOrderHistory()) {
            // Add the cost of each order to the total amount spent
            totalSpent += order.orderCost();
        }
        return totalSpent;
    }// END of calculateTotalSpent()

}//END of Class DessertShop
