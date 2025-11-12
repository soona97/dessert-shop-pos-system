 /*File: "SundaeTest.java"
  * Author: Aldo Velasquez & Oliver Rivera
  * Course: CS-115-01
  * Instructor: Barbara Chamberlin
  * Date: Feb 2, 2024
  * Description:
  *		*Test methods of Candy Class
  *		*Test Override calculateCost() abstract method used in DessertItem
  *		*Test DessertItem class testCalculateTax() method, making use of local calculateCost() method.
  */

 package DessertShop;

 import static org.junit.jupiter.api.Assertions.*;

 import org.junit.jupiter.api.Test;

 class SundaeTest {

     @Test
     void testGetToppingName() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         assertEquals("Dulce de Leche", s1.getToppingName());
     }

     @Test
     void testGetToppingPrice() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         assertEquals(0.99, s1.getToppingPrice(), 0.01);
     }

     @Test
     void testSetToppingName() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         s1.setToppingName("Chocolate Chips");
         assertEquals("Chocolate Chips", s1.getToppingName());
     }

     @Test
     void testSetToppingPrice() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         s1.setToppingPrice(0.5);
         assertEquals(0.5, s1.getToppingPrice(), 0.01);
     }

     //Added methods
     @Test
     public void testCalculateCost() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         assertEquals(5.99, s1.calculateCost(), 0.01);
     }

     @Test
     public void testCalculateTax() {
         Sundae s1 = new Sundae("McSundae", 2, 2.5, "Dulce de Leche", 0.99);
         assertEquals(0.434275, s1.calculateTax(), 0.000001);
     }

 }//END of SundaeTest