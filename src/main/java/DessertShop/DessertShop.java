/*File: "DessertShop.java"
 * Lab 5a: Dessert Shop, Part 5—Print Receipt
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 9, 2024
 * Description:
 * 		* Commented out the previous print style and changed it to only one line of code calling the formated order class structure
 */

package DessertShop;

import java.util.Scanner;

public class DessertShop {

    public static void main(String[] args) {

        // Create a new instance of the Order class
        Order order = new Order();

        //Code Added from Lab4B CREATES MENU TO ADD DESSERT ITEMS TO THE ORDER
        Scanner sIn = new Scanner(System.in);
        String choice;
        DessertItem orderItem;

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

        //Close the Scanner
        sIn.close();

        System.out.println("\n");//END of Code Added Lab4B


        // Add items to the order
        order.addDessertItem(new Candy("Candy Corn", 1.5, 0.25));
        order.addDessertItem(new Candy("Gummy Bears", 0.25, 0.35));
        order.addDessertItem(new Cookie("Chocolate Chip", 6, 3.99));
        order.addDessertItem(new IceCream("Pistachio", 2, 0.79));
        order.addDessertItem(new Sundae("Vanilla", 3, 0.69, "Hot Fudge", 1.29));
        order.addDessertItem(new Cookie("Oatmeal Raisin", 2, 3.45));

		/*
		// Print the name of each DessertItem in the order
		System.out.println("Items in the order:\n");

		//This will print all the items in the order DessertItem Array list and stop when last item is added.
		for (int i = 0; i < order.getOrderList().size(); i++) {
		    DessertItem item = order.getOrderList().get(i);
		    if (item instanceof Sundae) {
		        System.out.printf("%s%n", ((Sundae) item).toString()); // Cast to Sundae and call toString()
		    } else {
		        System.out.printf("%-35s$%-9.2f[Tax: $%.2f]%n", item.getName(), item.calculateCost(), item.calculateTax());
		    }
		}//END of For Loop

		//Print Order Subtotal, total, and Tax Total
		double subtotal = order.orderCost();
		double totalTax = order.orderTax();
		double totalCost = subtotal + totalTax;

		System.out.println("------------------------------------------------------");
		System.out.printf("Order Subtotals:                   $%-9.2f[Tax: $%.2f]\n", subtotal, totalTax);
		System.out.printf("Order Total:                       $%.2f\n", totalCost);


		// Print the total number of items in the order
		System.out.println("\nTotal number of items in the order: " + order.getItemCount());
		 */

        // Replace the code responsible for printing to the console with a single line to print out the receipt
        System.out.println(order); // This will print the receipt


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
