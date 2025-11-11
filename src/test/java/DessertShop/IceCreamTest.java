 /*File: "IceCreamTest.java"
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

 class IceCreamTest {

     @Test
     void testGetScoopCount() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         assertEquals(2, i1.getScoopCount());
     }

     @Test
     void testGetPricePerScoop() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         assertEquals(2.5, i1.getPricePerScoop(), 0.01);
     }

     @Test
     void testSetScoopCount() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         i1.setScoopCount(3);
         assertEquals(3, i1.getScoopCount());
     }

     @Test
     void testSetPricePerScoop() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         i1.setPricePerScoop(3.5);
         assertEquals(3.5, i1.getPricePerScoop(), 0.01);
     }

     //Added Methods
     @Test
     public void testCalculateCost() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         assertEquals(5.00, i1.calculateCost(), 0.01);
     }

     @Test
     public void testCalculateTax() {
         IceCream i1 = new IceCream("Oreo Ice Cream", 2, 2.5);
         assertEquals(0.3625, i1.calculateTax(), 0.0001);
     }

 }//END of IceCreamTest

