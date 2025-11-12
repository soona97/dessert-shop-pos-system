/*File: "SameItem.java"
 * Lab 7a: Dessert Shop, Part 9—Combine Like Items
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin
 * Date: Feb 24, 2024
 * Description:
 * 		* Line 15: The SameItem interface will be a generic interface.
 * 		* Line 16: Include the isSameAs(T) method:
 *
 */

package DessertShop;

public interface SameItem<T> {
    boolean isSameAs(T other);
}
