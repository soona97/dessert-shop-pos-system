/*File: "CandyTest.java"
 * Lab 7a: Dessert Shop, Part 9—Combine Like Items
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 *		* Create test cases that will test both true and false returns from isSameAs(Candy):
 *				true test case should compare two candies with:
 *						same name
 *						different weights
 *						same price per pound
 *				false test case should compare two candies:
 *						same name
 *						same weights
 *						different price per pound
 */

package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandyTest {

    @Test
    void testGetCandyWeight() {
        Candy c1 = new Candy("Push pop", 0.5, 0.99);
        assertEquals(0.5, c1.getCandyWeight(), 0.001);
    }

    @Test
    void testGetPricePerPound() {
        Candy c1 = new Candy("Push pop", 0.5, 0.99);
        assertEquals(0.99, c1.getPricePerPound(), 0.01);
    }

    @Test
    void testSetCandyWeight() {
        Candy c1 = new Candy("Push pop", 0.5, 0.99);
        c1.setCandyWeight(0.8);
        assertEquals(0.8, c1.getCandyWeight(), 0.001);
    }

    @Test
    void testSetPricePerPound() {
        Candy c1 = new Candy("Push pop", 0.5, 0.99);
        c1.setPricePerPound(0.79);
        assertEquals(0.79, c1.getPricePerPound(), 0.01);
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

    @Test
    void testIsSameAsTrue() {
        // Create two candy objects with the same name, different Candy Weight, and Same pricePerPound.
        Candy candy1 = new Candy("Gummy Bears", 0.35, 0.35);
        Candy candy2 = new Candy("Gummy Bears", 0.25, 0.35);

        // Check if the candies are considered the same
        assertTrue(candy1.isSameAs(candy2)); // Should return true
    }

    @Test
    void testIsSameAsFalse() {
        // Create two candy objects with the same name, same Candy Weight, but different pricePerPound.
        Candy candy1 = new Candy("Gummy Bears", 0.30, 0.25);
        Candy candy2 = new Candy("Gummy Bears", 0.30, 0.35);

        // Check if the candies are considered the same
        assertFalse(candy1.isSameAs(candy2)); // Should return false
    }

}//END of CandyTest
