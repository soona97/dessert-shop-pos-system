/*File: "CookieTest.java"
 * Lab 7a: Dessert Shop, Part 9—Combine Like Items
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 *		* Create test cases that will test both true and false returns from isSameAs(Candy):
 *				true test case should compare two Cookies with:
 *						same name
 *						different CookieQty
 *						same pricePerDozen
 *				false test case should compare two Cookies:
 *						same name
 *						same CookieQty
 *						different pricePerDozen
 */

package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CookieTest {

    @Test
    void testGetCookieQty() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        assertEquals(3, c1.getCookieQty());
    }

    @Test
    void testGetPricePerDozen() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        assertEquals(3.5, c1.getPricePerDozen());
    }

    @Test
    void testSetCookieQty() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        c1.setCookieQty(5);
        assertEquals(5, c1.getCookieQty());
    }

    @Test
    void testSetPricePerDozen() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        c1.setPricePerDozen(5.5);
        assertEquals(5.5, c1.getPricePerDozen());
    }

    //Added Methods
    @Test
    public void testCalculateCost() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        assertEquals(0.875, c1.calculateCost(), 0.001);
    }

    @Test
    public void testCalculateTax() {
        Cookie c1 = new Cookie("Oreos", 3, 3.5);
        assertEquals(0.0634375, c1.calculateTax(), 0.0000001);
    }

    @Test
    void testIsSameAsTrue() {
        // Create two candy objects with the same name, different CookieQty, and Same pricePerDozen.
        Cookie cookie1 = new Cookie("Chocolate Chip", 12, 3.99);
        Cookie cookie2 = new Cookie("Chocolate Chip", 12, 3.99);

        // Check if the cookies are considered the same
        assertTrue(cookie1.isSameAs(cookie2)); // Should return true
    }

    @Test
    void testIsSameAsFalse() {
        // Create two candy objects with the same name, same CookieQty, but different pricePerDozen.
        Cookie cookie1 = new Cookie("Chocolate Chip", 12, 3.99);
        Cookie cookie2 = new Cookie("Chocolate Chip", 12, 4.99);

        // Check if the cookies are considered the same
        assertFalse(cookie1.isSameAs(cookie2)); // Should return false
    }

}//END of CookieTest