/*File: "DessertItemTest.java"
 * Lab 6b: Dessert Shop Part 8: Sort Receipt
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 17, 2024
 * Description:
 * 		* Create test cases that will test all possible return values of compareTo(DessertItem):
 * 				Line 64: -1
 * 				Line 71: 1
 * 				Line 78: 0
 */

package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DessertItemTest {

    @Test
    void testGetName() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        assertEquals("Test Dessert", d1.getName());
    }

    @Test
    void testSetName() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        d1.setName("Updated Dessert");
        assertEquals("Updated Dessert", d1.getName());
    }

    //Added Methods
    @Test
    void testGetTaxPercent() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        assertEquals(7.25, d1.getTaxPercent(), 0.01);
    }

    @Test
    void testSetTaxPercent() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        d1.setTaxPercent(8.25);
        assertEquals(8.25, d1.getTaxPercent(), 0.01);
    }

    //Added Interface Methods LAB5B
    @Test
    void testGetPackaging() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        assertEquals("Bag", d1.getPackaging());
    }

    @Test
    void testSetPackaging() {
        Candy d1 = new Candy("Test Dessert", 0.5, 0.99);
        d1.setPackaging("Bags");
        assertEquals("Bags", d1.getPackaging());
    }

    @Test
    void testCompareTo_LessThan() {
        DessertItem item1 = new Candy("Candy1", 1.0, 1.0);
        DessertItem item2 = new Candy("Candy2", 2.0, 2.0);
        assertEquals(-1, item1.compareTo(item2));
    }

    @Test
    void testCompareTo_GreaterThan() {
        DessertItem item1 = new Candy("Candy1", 2.0, 2.0);
        DessertItem item2 = new Candy("Candy2", 1.0, 1.0);
        assertEquals(1, item1.compareTo(item2));
    }

    @Test
    void testCompareTo_Equal() {
        DessertItem item1 = new Candy("Candy1", 1.0, 1.0);
        DessertItem item2 = new Candy("Candy2", 1.0, 1.0);
        assertEquals(0, item1.compareTo(item2));
    }

}//END of DessertItemTest
