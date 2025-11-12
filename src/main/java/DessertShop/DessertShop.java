/*File: "DessertShop.java"
 * Lab 7b: Dessert Shop, Part 10—Customer Class
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 * 		* Line 32, 121: Put the entire functionality of the main() method in a continuous loop so that the program starts a new order each time you finish entering an order.
 * 		* Line 118-119: After the receipt has been printed, pause the program and ask the user to hit enter to start a new order
 */

package DessertShop;

import java.util.Collections;
import java.util.Scanner;

import DessertShop.Payable.PayType;

public class DessertShop {

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

                System.out.print("\nWhat would you like to add to the order? (1-4, Enter for done): ");
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

            //Ask user for payment method
            String paymentMethod;
            boolean valid = false;
            while (!valid) {
                System.out.println("What form of payment will be used? (CASH, CARD, PHONE):");
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

            // Pause and ask user to hit enter to start a new order
            System.out.println("\nPress Enter to start a new order...");
            sIn.nextLine(); // Wait for user to press enter

        }//END of outer While loop for store open or closed

        //Close the Scanner
        sIn.close();

    }//END of main() Method


    //Methods added for Lab 4B
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


    //userPromptCookie
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


    //userPromptIceCream()
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

    //userPromptSundae
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
    
}//END of Class DessertShop
