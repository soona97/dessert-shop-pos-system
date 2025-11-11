/*File: "Payable.java"
 * Lab 6a: Dessert Shop, Part 7—Payment Method
 * Author: Aldo Velasquez & Oliver Rivera
 * Course: CS-115-01
 * Instructor: Barbara Chamberlin 
 * Date: Feb 15, 2024
 * Description: 
 * 		* Created Interface for Payable which will be implemented on order Class.
 * 		* Defined enum PayType values
 * 		* Added getter and setter method for PayType  
 */

package DessertShop;

public interface Payable {

	enum PayType{
		CASH,
		CARD,
		PHONE
	}

	//getPayType() that takes no arguments and returns a PayType
	PayType getPayType();
	//setPayType(PayType) that takes a single PayType argument and returns void
	void setPayType(PayType payType);

}//END of Payable Interface
