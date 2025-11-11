 /*File: "CandyTest.java"
  * Author: Aldo Velasquez & Oliver Rivera
  * Course: CS-115-01
  * Instructor: Barbara Chamberlin
  * Date: Feb 2, 2024
  * Description:
  *		*Test methods of Candy Class
  *		*Override calculateCost() abstract method used in DessertItem
  *		*Test DessertItem class testCalculateTax() method, making use of local calculateCost() method.
  */

 package DessertShop;

 import static org.junit.jupiter.api.Assertions.*;

 import org.junit.jupiter.api.Test;

 class CandyTest {

     @Test
     void testGetCandyWeight() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         assertEquals(0.5, c1.getCandyWeight(),0.001);
     }

     @Test
     void testGetPricePerPound() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         assertEquals(0.99, c1.getPricePerPound(),0.01);
     }

     @Test
     void testSetCandyWeight() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         c1.setCandyWeight(0.8);
         assertEquals(0.8, c1.getCandyWeight(),0.001);
     }

     @Test
     void testSetPricePerPound() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         c1.setPricePerPound(0.79);
         assertEquals(0.79, c1.getPricePerPound(),0.01);
     }

     //Added Methods
     @Test
     public void testCalculateCost() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         assertEquals(0.495, c1.calculateCost(), 0.001);
     }

     @Test
     public void testCalculateTax() {
         Candy c1 = new Candy("Push pop", 0.5, 0.99);
         assertEquals(0.0358875, c1.calculateTax(), 0.0000001);
     }

 }//END of CandyTest
