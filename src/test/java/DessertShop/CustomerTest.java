package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testGetName() {
        Customer customer = new Customer("John Doe");
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void testGetID() {
        Customer customer = new Customer("John Doe");
        assertEquals(1000, customer.getID()); // Assuming the initial nextCustID value is 1000
    }

    @Test
    void testSetName() {
        Customer customer = new Customer("John Doe");
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    void testAddToHistory() {
        Customer customer = new Customer("John Doe");
        Order order = new Order();
        customer.addToHistory(order);
        assertEquals(1, customer.getOrderHistory().size());
    }

}
